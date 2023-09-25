package alex.test.NumberGenerator.repo;

import alex.test.NumberGenerator.model.CarNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarNumberRepo extends JpaRepository<CarNumber, Integer> {
    @Query("SELECT cn " +
            "FROM CarNumber cn " +
            "WHERE cn.firstChar = :firstChar " +
            "AND cn.number = :number " +
            "AND cn.secondChar = :secondChar " +
            "AND cn.thirdChar = :thirdChar")
    CarNumber findCarNumber(
            @Param("firstChar") Character firstChar,
            @Param("number") Integer number,
            @Param("secondChar") Character secondChar,
            @Param("thirdChar") Character thirdChar);

    @Query("SELECT (COUNT(cn) > 0) " +
            "FROM CarNumber cn " +
            "WHERE cn.firstChar = :firstChar " +
            "AND cn.number = :number " +
            "AND cn.secondChar = :secondChar " +
            "AND cn.thirdChar = :thirdChar")
    boolean existsCarNumber(
            @Param("firstChar") Character firstChar,
            @Param("number") Integer number,
            @Param("secondChar") Character secondChar,
            @Param("thirdChar") Character thirdChar);

    @Query("SELECT cn " +
            "FROM CarNumber cn " +
            "WHERE cn.count = " +
            "(SELECT MAX(cn.count) " +
            "FROM cn)")
    List<CarNumber> findCarNumberWithMaxCount();

    @Query("SELECT MAX(cn.count) " +
            "FROM CarNumber cn")
    int maxCount();

    @Query("SELECT COUNT(cn) " +
            "FROM CarNumber cn")
    int amount();
}
