package ar.edu.huergo.scaputo.sbigliardi.nextmatch.repository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity.Equipo;

@DataJpaTest
public class EquipoRepositoryTest {

    @Autowired
    private EquipoRepository equipoRepository;

    @Test
    public void testSaveAndFindById() {
        Equipo equipo = new Equipo("Equipo A");
        Equipo savedEquipo = equipoRepository.save(equipo);

        Optional<Equipo> foundEquipo = equipoRepository.findById(savedEquipo.getId());

        assertTrue(foundEquipo.isPresent());
        assertEquals("Equipo A", foundEquipo.get().getNombre());
    }

    @Test
    public void testFindAll() {
        equipoRepository.save(new Equipo("Equipo A"));
        equipoRepository.save(new Equipo("Equipo B"));

        Iterable<Equipo> equipos = equipoRepository.findAll();
        List<Equipo> equipoList = (List<Equipo>) equipos;

        assertEquals(2, equipoList.size());
    }

    @Test
    public void testDeleteById() {
        Equipo equipo = equipoRepository.save(new Equipo("Equipo A"));
        Long id = equipo.getId();

        equipoRepository.deleteById(id);

        Optional<Equipo> foundEquipo = equipoRepository.findById(id);
        assertFalse(foundEquipo.isPresent());
    }
}
