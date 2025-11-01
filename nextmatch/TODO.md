# TODO - Aplicación de Testing en NextMatch

## Tests Creados
- [x] EquipoControllerTest - Pruebas unitarias para EquipoController usando @WebMvcTest
- [x] EquipoServiceTest - Pruebas unitarias para EquipoService usando Mockito
- [x] EquipoRepositoryTest - Pruebas de integración para EquipoRepository usando @DataJpaTest
- [x] UsuarioControllerTest - Pruebas unitarias para UsuarioController usando @WebMvcTest
- [x] UsuarioServiceTest - Pruebas unitarias para UsuarioService usando Mockito
- [x] LigaServiceTest - Pruebas unitarias para LigaService usando Mockito
- [x] TecnicoServiceTest - Pruebas unitarias para TecnicoService usando Mockito
- [x] EstadisticaServiceTest - Pruebas unitarias para EstadisticaService usando Mockito

## Tests Pendientes
- [ ] UsuarioRepositoryTest - Pruebas para UsuarioRepository
- [ ] RolRepositoryTest - Pruebas para RolRepository
- [ ] AuthControllerTest - Pruebas para AuthController (si existe)
- [ ] JwtTokenServiceTest - Pruebas para JwtTokenService
- [ ] EquipoMapperTest - Pruebas para EquipoMapper
- [ ] UsuarioMapperTest - Pruebas para UsuarioMapper
- [ ] PasswordValidatorTest - Pruebas para PasswordValidator
- [ ] SecurityConfigTest - Pruebas para SecurityConfig
- [ ] JwtAuthenticationFilterTest - Pruebas para JwtAuthenticationFilter
- [ ] DataInitializerTest - Pruebas para DataInitializer

## Próximos Pasos
- Ejecutar los tests creados con `./gradlew test`
- Agregar más casos de prueba para cubrir edge cases
- Implementar tests de integración end-to-end si es necesario
- Revisar cobertura de código con herramientas como JaCoCo
