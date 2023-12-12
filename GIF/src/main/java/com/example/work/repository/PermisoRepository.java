package com.example.work.repository;

import com.example.work.entity.Permiso;
import com.example.work.entity.PermisoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PermisoRepository extends JpaRepository<Permiso, PermisoId> {


}
