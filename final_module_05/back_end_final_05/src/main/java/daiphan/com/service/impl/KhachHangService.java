package daiphan.com.service.impl;

import daiphan.com.model.KhachHang;
import daiphan.com.repository.IKhachHangRepository;
import daiphan.com.service.IKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangService implements IKhachHangService<KhachHang> {

    @Autowired
    private IKhachHangRepository iKhachHangRepository;

    @Override
    public List<KhachHang> findAll() {
        return iKhachHangRepository.findAll();
    }

    @Override
    public KhachHang findById(int id) {
        return iKhachHangRepository.findById(id).orElse(null);
    }
}
