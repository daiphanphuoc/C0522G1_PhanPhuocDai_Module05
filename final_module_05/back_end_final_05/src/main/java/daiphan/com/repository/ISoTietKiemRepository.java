package daiphan.com.repository;

import daiphan.com.model.SoTietKiem;
import daiphan.com.model.ISoTietKiemDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ISoTietKiemRepository extends JpaRepository<SoTietKiem,Integer> {

    @Query(value = "select kh.ten as ten,kh.id as idKhach, st.id as id, st.ky_han as kyHan, lai_suat as laiSuat, " +
            "ngay_gui as ngayGui, ngay_mo_so as ngayMoSo, tien_gui as tienGui, uu_dai as uuDai " +
            "from  Khach_Hang kh join So_Tiet_Kiem st on kh.id = st.khach_hang_id" +
            " where kh.ten like %:searchName or st.id = :id ",
            countQuery = "select count(*) from  Khach_Hang kh join So_Tiet_Kiem st on kh.id = st.khach_hang_id " +
                    "            where kh.ten like %:searchName or st.id = :id ",
            nativeQuery = true)
    Page<ISoTietKiemDto> searchAll(@Param("searchName") String searchName, @Param("id") int id, Pageable pageable);

    @Query(value = "select kh.ten as ten,kh.id as idKhach, st.id as id, st.ky_han as kyHan, lai_suat as laiSuat, " +
            "ngay_gui as ngayGui, ngay_mo_so as ngayMoSo, tien_gui as tienGui, uu_dai as uuDai " +
            "from  Khach_Hang kh join So_Tiet_Kiem st on kh.id = st.khach_hang_id" +
            " where st.id = :id ",
            nativeQuery = true)
    ISoTietKiemDto searchById(@Param("id") int id);
}
