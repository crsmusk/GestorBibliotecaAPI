package com.api.api.Servicio.Interface;

import java.util.List;


import com.api.api.Model.DTO.prestamoDto;
public interface Iprestamo {
  
    public List<prestamoDto> findAll();

    public prestamoDto findById(Long id);

    public void save(prestamoDto prestamo);

    public void delete(Long id);

    public void addBook(Long id,String titulo);

    public void returnBook(Long id,String titulo);

    public List<prestamoDto>lateLoans();

    public List<prestamoDto>loansEarrings();
}
