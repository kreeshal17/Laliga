package SearchPlusCRUD.SearchPlusCRUD;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {
  @Autowired
  Repostitory repo;

    public  void addDetails(Laliga l) {

        repo.save(l);

    }

    public List<Laliga> getDetails() {
       return  repo.findAll();

    }

    public void deleteDetail(int id) {
        repo.deleteById(id);


    }

    public List<Laliga> searchFromKeyWord(String keyword) {
       return   repo.searchFromkeyword(keyword);
    }

    public Laliga addProduct(Laliga laliga, MultipartFile imagefile) throws IOException {
        laliga.setImagename(imagefile.getOriginalFilename());
        laliga.setImageType(imagefile.getContentType());
        laliga.setImagedata(imagefile.getBytes());


        return repo.save(laliga);

    }

    public Laliga getProductBYId(int id) {
        return repo.findById(id).orElse(null);
    }
}
