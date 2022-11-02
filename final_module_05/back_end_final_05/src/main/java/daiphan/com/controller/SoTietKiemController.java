package daiphan.com.controller;

import daiphan.com.model.SoTietKiem;
import daiphan.com.model.ISoTietKiemDto;
import daiphan.com.model.SoTietKiemDto;
import daiphan.com.service.ISoTietKiemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/soTietKiems")
@CrossOrigin("*")
public class SoTietKiemController {

    @Autowired
    private ISoTietKiemService<SoTietKiem> soTietKiemService;

    @GetMapping("")
    public ResponseEntity<Page<ISoTietKiemDto>> getAllBySearch(@RequestParam(defaultValue = "") String searchName,
                                                               @RequestParam(defaultValue = "0") int id,
                                                               @PageableDefault(value = 5) Pageable pageable    ) {
        Page<ISoTietKiemDto> soTietKiemDtoPage = soTietKiemService.searchAll(searchName, id, pageable);
        if (soTietKiemDtoPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(soTietKiemDtoPage, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Page<SoTietKiem>> getAll(@PageableDefault(value = 5) Pageable pageable) {

        Page<SoTietKiem> soTietKiemPage = soTietKiemService.findAll(pageable);
        if (soTietKiemPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(soTietKiemPage, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ISoTietKiemDto> getById(@PathVariable int id) {

        ISoTietKiemDto soTietKiem = soTietKiemService.searchById(id);
        if (soTietKiem == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(soTietKiem, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SoTietKiem> deleteById(@PathVariable int id) {

        SoTietKiem soTietKiem = soTietKiemService.findById(id);
        if (soTietKiem == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        boolean b = soTietKiemService.deleteElement(id);
        if(b) {
            return new ResponseEntity<>(soTietKiem, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<SoTietKiem> updateElement(@PathVariable int id,@RequestBody SoTietKiemDto soTietKiemDto) {
        System.out.println(id);
        SoTietKiem soTietKiem = soTietKiemService.findById(id);
        System.out.println(soTietKiemDto.getTienGui());
        if (soTietKiem == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        BeanUtils.copyProperties(soTietKiemDto, soTietKiem);
        boolean b = soTietKiemService.updateElement(soTietKiem);
        if(b) {
            return new ResponseEntity<>(soTietKiem, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    public ResponseEntity<SoTietKiem> saveElement(@RequestBody SoTietKiemDto soTietKiemDto) {
        SoTietKiem  soTietKiem = new SoTietKiem();
        BeanUtils.copyProperties(soTietKiemDto, soTietKiem);
        return new ResponseEntity<>(soTietKiemService.saveElement(soTietKiem), HttpStatus.CREATED);
    }
}
