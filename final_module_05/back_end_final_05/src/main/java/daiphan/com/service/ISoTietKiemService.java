package daiphan.com.service;

import daiphan.com.model.ISoTietKiemDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISoTietKiemService<T> {

    Page<T> findAll(Pageable pageable);

    T findById(int id);

    T saveElement(T element);

    boolean deleteElement(int id);

    Page<ISoTietKiemDto> searchAll(String searchName, int id, Pageable pageable);

    boolean updateElement( T soTietKiem);

    ISoTietKiemDto searchById(int id);
}
