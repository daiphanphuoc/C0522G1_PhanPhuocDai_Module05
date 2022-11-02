package daiphan.com.service.impl;

import daiphan.com.model.SoTietKiem;
import daiphan.com.model.ISoTietKiemDto;
import daiphan.com.repository.ISoTietKiemRepository;
import daiphan.com.service.ISoTietKiemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SoTietKiemService implements ISoTietKiemService<SoTietKiem> {

    @Autowired
    private ISoTietKiemRepository iSoTietKiemRepository;

    @Override
    public Page<SoTietKiem> findAll(Pageable pageable) {
        return iSoTietKiemRepository.findAll(pageable);
    }

    @Override
    public SoTietKiem findById(int id) {
        return iSoTietKiemRepository.findById(id).orElse(null);
    }

    @Override
    public SoTietKiem saveElement(SoTietKiem element) {
        return iSoTietKiemRepository.save(element);
    }

    @Override
    public boolean deleteElement(int id) {
        try {
            iSoTietKiemRepository.deleteById(id);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Override
    public Page<ISoTietKiemDto> searchAll(String searchName, int id, Pageable pageable) {
        return iSoTietKiemRepository.searchAll(searchName, id, pageable);
    }

    @Override
    public boolean updateElement(SoTietKiem soTietKiem) {
        try {
            iSoTietKiemRepository.save(soTietKiem);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Override
    public ISoTietKiemDto searchById(int id) {
        return iSoTietKiemRepository.searchById(id);
    }
}
