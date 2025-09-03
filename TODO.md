# TODO: Arreglar EquipoMapper y Borrar Ingredientes

## Pasos a Completar

- [ ] Arreglar EquipoMapper: Eliminar importación no utilizada de IngredienteDTO
- [ ] Modificar Equipo.java: Remover campo ingredientes y anotaciones relacionadas
- [ ] Modificar CrearActualizarEquipoDTO.java: Remover campo ingredientesIds
- [ ] Modificar MostrarEquipoDTO.java: Remover campo ingredientes
- [ ] Modificar EquipoService.java: Remover referencias a IngredienteService y métodos relacionados con ingredientes
- [ ] Modificar EquipoController.java: Remover referencias a ingredientesIds
- [ ] Eliminar archivos relacionados con Ingrediente:
  - IngredienteController.java
  - IngredienteService.java
  - IngredienteRepository.java
  - IngredienteMapper.java
  - IngredienteDTO.java
  - Ingrediente.java
- [ ] Verificar y remover cualquier otra referencia a Ingrediente en otros archivos
- [ ] Probar compilación para asegurar que no hay errores
