/**
 * Only for uploading images
 */

package ch.akmotors.sellingsite.api;

import ch.akmotors.sellingsite.config.FileStorageProperties;
import ch.akmotors.sellingsite.exception.FileStorageException;
import ch.akmotors.sellingsite.model.UploadFileResponse;
import ch.akmotors.sellingsite.service.FileStorageService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@CrossOrigin
@RequestMapping("${endpoint}/file")
public class FileController {

    private final Path fileStorageLocation;

    @Autowired
    FileStorageService fileStorageService;

    @Autowired
    public FileController(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();
    }

    //    @PostMapping("upload")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("id") String id) {
        String fileName = "error", newFilename = "error", fileDownloadUri = "error";
        File tmpFile; Path targetLocation;
        try {
            int counter = 1;
            // If <id>-<x> already exists, try with <id>-<x+1>
            do {
                String extension = FilenameUtils.getExtension(file.getOriginalFilename());
                newFilename = id + "-" + counter + "." + extension;
                targetLocation = this.fileStorageLocation.resolve(newFilename);
                counter++;
            } while (Files.exists(targetLocation));


            MultipartFile newFile = new MockMultipartFile(newFilename, newFilename, file.getContentType(), file.getInputStream());

            fileName = fileStorageService.storeFile(newFile);

            fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/downloadFile/")
                    .path(newFilename)
                    .toUriString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
    }

    @PostMapping("/upload")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files, @RequestParam("AdId") String AdId) {
        deleteFilesBeginningWith(AdId);

        return Arrays.asList(files)
                .stream()
                .map((file) -> uploadFile(file, AdId))
                .collect(Collectors.toList());
    }

    @DeleteMapping("delete/{AdId}")
    public void deleteFilesBeginningWith(@PathVariable String AdId) {
        // Delete all images beginning with id given
        for (File f : this.fileStorageLocation.toFile().listFiles()) {
            System.out.println(f.getName());
            if (f.getName().startsWith(AdId)) {
                f.delete();
            }
        }
    }

}
