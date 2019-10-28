// https://www.callicoder.com/spring-boot-file-upload-download-rest-api-example/

package ch.akmotors.sellingsite.service;

import ch.akmotors.sellingsite.config.FileStorageProperties;
import ch.akmotors.sellingsite.exception.FileStorageException;
import ch.akmotors.sellingsite.exception.MyFileNotFoundException;
import org.apache.tools.ant.DirectoryScanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileStorageService {

    private final Path fileStorageLocation;

    @Autowired
    public FileStorageService(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();

        try {
            System.out.println("Working Directory = " +
                    System.getProperty("user.dir"));
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    public String storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("File not found " + fileName, ex);
        }
    }

    public Resource loadFileAsResourceWithoutKnowingExtension(String fileNameWithoutExt) {
        String fileWithExt = findFileWithExt(fileNameWithoutExt);

        try {
            Path filePath = this.fileStorageLocation.resolve(fileWithExt).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("File not found " + fileNameWithoutExt);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("File not found " + fileNameWithoutExt, ex);
        }
    }

    private String findFileWithExt(String fileNameWithoutExt) {
        DirectoryScanner scanner = new DirectoryScanner();
        scanner.setIncludes(new String[]{fileNameWithoutExt + ".*"});
        scanner.setBasedir(this.fileStorageLocation.toFile());
        scanner.setCaseSensitive(false);
        scanner.scan();
        return scanner.getIncludedFiles()[0];
    }

}