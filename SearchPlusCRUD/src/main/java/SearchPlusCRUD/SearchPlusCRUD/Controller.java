package SearchPlusCRUD.SearchPlusCRUD;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/laliga")
public class Controller {
    @Autowired
    Service service;


    @GetMapping
    public List<Laliga> getDetails()
    {
       return service.getDetails();

    }


    @PostMapping()

    public  void addProduct(@RequestBody Laliga l)
    {
        service.addDetails(l);
    }


    @DeleteMapping("/{id}")
    public void delDetail(@PathVariable int id)
    {
        service.deleteDetail(id);
    }

    @GetMapping("/search")

    public List<Laliga> searchFromKeyWord(@RequestParam   String keyword)
    {
          return service.searchFromKeyWord(keyword);

    }

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestPart Laliga laliga, @RequestPart MultipartFile imagefile)
    {
         try{
            Laliga laliga1= service.addProduct(laliga,imagefile);
            return  new ResponseEntity<>(laliga1,HttpStatus.CREATED);


         }
         catch(Exception e)
        {
                 return  new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);

        }


    }



    @GetMapping("/kree/{id}")
       public ResponseEntity<byte[]> getProductImagebYid(@PathVariable int id)
    {
        Laliga laliga=service.getProductBYId(id);
        byte[] imagefile= laliga.getImagedata();

        return  ResponseEntity.ok().contentType(MediaType.valueOf(laliga.getImageType())).
                body(imagefile);



    }








}
