package com.f1.records.repositorys;

import com.f1.records.pojos.DAOs.QualifyingDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface QualifyingRepository extends PagingAndSortingRepository<QualifyingDAO, Integer> {
    Page<QualifyingDAO> getQualifyingDTOByRaceId(int raceId, Pageable pageable);
    QualifyingDAO getQualifyingDTOByRaceIdAndDriverId(int raceId, int driverId);
    Page<QualifyingDAO> getQualifyingDTOByRaceIdAndConstructorId(int raceId, int constructorId, Pageable pageable);

    @Query("select q from QualifyingDAO q where q.raceDAO.name = ?1 and q.constructorDAO.name = ?2")
    Page<QualifyingDAO> getQualifyingByRaceNameAndConstructorName(String raceName, String constructorName, Pageable pageable);

    @Query("select q from QualifyingDAO q where q.raceDAO.name = ?1 and q.driverDAO.forename = ?2 and q.driverDAO.surname = ?3")
    Page<QualifyingDAO> getQualifyingByRaceNameAndDriverFullName(String raceName, String forename, String surname, Pageable pageable);

    @Query("select q from QualifyingDAO q where q.raceDAO.name = ?1 and q.raceDAO.year = ?2")
    Page<QualifyingDAO> getQualifyingByRaceNameAndRaceYear(String name, int year, Pageable pageable);


    @Query("select q from QualifyingDAO q where q.raceDAO.name = ?1 and q.raceDAO.year = ?2 and q.driverDAO.forename = ?3 and q.driverDAO.surname = ?4")
    QualifyingDAO getQualifyingByRaceNameAndRaceYearAndDriverFullName(String raceName, int year, String forename, String surname);
}
