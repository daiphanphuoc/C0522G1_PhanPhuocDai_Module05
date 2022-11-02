package daiphan.com.service;

import java.util.List;

public interface IKhachHangService<T> {
    List<T> findAll();
    T findById(int id);
}
