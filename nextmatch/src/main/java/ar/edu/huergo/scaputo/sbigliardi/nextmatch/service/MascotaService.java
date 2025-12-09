package ar.edu.huergo.scaputo.sbigliardi.nextmatch.service;

@Service
public class MascotaService {

    @Autowired
    private MascotaRepository repo;

    public Mascota crear(Mascota m) {
        return repo.save(m);
    }

    public List<Mascota> obtenerTodos() {
        return repo.findAll();
    }

    public Mascota obtenerPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No encontrado"));
    }

    public Mascota actualizar(Long id, Mascota nuevosDatos) {
        Mascota m = obtenerPorId(id);
        m.setNombre(nuevosDatos.getNombre());
        m.setTipo(nuevosDatos.getTipo());
        m.setEdad(nuevosDatos.getEdad());
        m.setAdoptado(nuevosDatos.getAdoptado());
        return repo.save(m);
    }

    public void eliminar(Long id) {
        repo.delete(obtenerPorId(id));
    }
}
