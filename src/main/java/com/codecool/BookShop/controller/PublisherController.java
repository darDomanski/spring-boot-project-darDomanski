package com.codecool.BookShop.controller;

import com.codecool.BookShop.model.Publisher;
import com.codecool.BookShop.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class PublisherController {

        @Autowired
        private PublisherService publisherService;

        @GetMapping("/publisher")
        public List<Publisher> retrieveAllPublisher() {
            return publisherService.findAll();
        }

        @GetMapping("/publisher/{id}")
        public Publisher retrievePublisher(@PathVariable long id) {
            Optional<Publisher> publisher = publisherService.findById(id);
//            if (!bookform.isPresent())
//                throw new PublisherNotFoundException("id-" + id);
            return publisher.get();
        }

//        @DeleteMapping("/publisher/{id}")
//        public void deletePublisher(@PathVariable long id) {
//            publisherService.deleteById(id);
//        }

        @DeleteMapping("/publisher/{id}")
        public String deletePublisher(@PathVariable Long id) {
            if(publisherService.existsById(id)) {
                publisherService.deleteById(id);
                return "deleted";
            }
            return "Genre do not exist in database!";
        }

//        @PostMapping("/publisher")
//        public ResponseEntity<Object> createPublisher(@RequestBody Publisher publisher) {
//            Publisher savedPublisher = publisherService.save(publisher);
//            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//                    .buildAndExpand(savedPublisher.getId()).toUri();
//            return ResponseEntity.created(location).build();
//        }

        @PostMapping("/publisher")
        public Publisher createPublisher(@RequestBody Publisher publisher) {
            Long publisherId = publisher.getId();
            if( publisherId != null && publisherService.existsById( publisherId ) ) {
                return null;
            }
            publisher.setId(null);
            return publisherService.save( publisher );
        }


        @PutMapping("/publisher")
            public Publisher updatePublisher(@RequestBody Publisher publisher) {
                return publisherService.save( publisher );
            }

}
