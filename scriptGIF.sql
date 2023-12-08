-- Sentencias INSERT tRol
INSERT INTO tRol (rolName, rolDes, admin) VALUES ('Administrador', 'Permite modificar eliminar y borrar datos', '1');
INSERT INTO tRol (rolName, rolDes, admin) VALUES ('Usuario', 'Permite unicamente modificar datos', '0');
INSERT INTO tRol (rolName, rolDes, admin) VALUES ('Invitado', 'No permite hacer nada con los datos', '0');

-- Sentencias INSERT tUsuario
INSERT INTO tUsuario (nif, password, rolName) VALUES ('00000000x', ' admin', ' Administrador');
INSERT INTO tUsuario (nif, password, rolName) VALUES ('00000001f', ' admin', ' Administrador');
INSERT INTO tUsuario (nif, password, rolName) VALUES ('10000000d', ' user', ' Usuario');
INSERT INTO tUsuario (nif, password, rolName) VALUES ('10000001j', ' user', ' Usuario');
INSERT INTO tUsuario (nif, password, rolName) VALUES ('20000000s', ' invitado', ' Invitado');
INSERT INTO tUsuario (nif, password, rolName) VALUES ('20000001k', ' invitado', ' Invitado');

-- Sentencias INSERT tMuestra
INSERT INTO tMuestra (ID, NIF_Paciente, Cultivo, Solucion) VALUES ('1', '10000000d', 'Células Sanguineas', '2');
INSERT INTO tMuestra (ID, NIF_Paciente, Cultivo, Solucion) VALUES ('2', '10000001j', 'Orina', '4');
INSERT INTO tMuestra (ID, NIF_Paciente, Cultivo, Solucion) VALUES ('3', '20000000s', 'Heces', '5');
INSERT INTO tMuestra (ID, NIF_Paciente, Cultivo, Solucion) VALUES ('4', '20000001k', 'Células Hepáticas', '7');
INSERT INTO tMuestra (ID, NIF_Paciente, Cultivo, Solucion) VALUES ('5', '10000000d', 'Médula Ósea', '9');
INSERT INTO tMuestra (ID, NIF_Paciente, Cultivo, Solucion) VALUES ('6', '10000001j', 'Tejido Nervioso', '12');
INSERT INTO tMuestra (ID, NIF_Paciente, Cultivo, Solucion) VALUES ('7', '20000000s', 'Células de Piel', '13');
INSERT INTO tMuestra (ID, NIF_Paciente, Cultivo, Solucion) VALUES ('8', '20000001k', 'Células Musculares', '16');

-- Sentencias INSERT tPermiso
INSERT INTO tPermiso (rolName, pantalla, acceso, insertar, modificar, borrar) VALUES ('Administrador', 'muestras', '1', '1', '1', '1');
INSERT INTO tPermiso (rolName, pantalla, acceso, insertar, modificar, borrar) VALUES ('Usuario', 'muestras', '1', '0', '1', '0');
INSERT INTO tPermiso (rolName, pantalla, acceso, insertar, modificar, borrar) VALUES ('Invitado', 'muestras', '1', '0', '0', '0');

-- Sentencias INSERT tSolucion
INSERT INTO tSolucion (ID, Solución, Uso) VALUES ('1', 'Ácido Acetilsalicílico', 'Antiagregante plaquetario que reduce la coagulación de la sangre.');
INSERT INTO tSolucion (ID, Solución, Uso) VALUES ('2', 'Warfarina', 'Anticoagulante que inhibe la síntesis de factores de coagulación.');
INSERT INTO tSolucion (ID, Solución, Uso) VALUES ('3', 'Furosemida', 'Diurético que aumenta la excreción de agua y electrolitos a través de la orina.');
INSERT INTO tSolucion (ID, Solución, Uso) VALUES ('4', 'Tamsulosina', 'Relajante muscular utilizado en trastornos urinarios como la hiperplasia prostática benigna.');
INSERT INTO tSolucion (ID, Solución, Uso) VALUES ('5', 'Loperamida', 'Antidiarreico que reduce la motilidad intestinal y disminuye la frecuencia de las deposiciones.');
INSERT INTO tSolucion (ID, Solución, Uso) VALUES ('6', 'Bisacodilo', 'Laxante que estimula el movimiento intestinal y facilita la evacuación.');
INSERT INTO tSolucion (ID, Solución, Uso) VALUES ('7', 'Acetaminofén', ' Analgésico y antipirético que es metabolizado en el hígado.');
INSERT INTO tSolucion (ID, Solución, Uso) VALUES ('8', 'Atorvastatina', 'Estatina que ayuda a reducir los niveles de colesterol que actúa en el hígado.');
INSERT INTO tSolucion (ID, Solución, Uso) VALUES ('9', 'Fligrastim', 'Factor estimulante de colonias de granulocitos que es utilizado para estimular la producción de células sanguíneas en la médula ósea.');
INSERT INTO tSolucion (ID, Solución, Uso) VALUES ('10', 'Eritropoyetina', 'Estimula la producción de glóbulos rojos en la médula ósea.');
INSERT INTO tSolucion (ID, Solución, Uso) VALUES ('11', 'Ibuprofeno', 'Antiinflamatorio no esteroideo (AINE) que alivia el dolor incluyendo el asociado con problemas nerviosos.');
INSERT INTO tSolucion (ID, Solución, Uso) VALUES ('12', 'Donepezilo', 'Inhibidor de la acetilcolinesterasa que se utiliza en el tratamiento del Alzheimer.');
INSERT INTO tSolucion (ID, Solución, Uso) VALUES ('13', 'Aciclovir', 'Antiviral utilizado en infecciones cutáneas como el herpes.');
INSERT INTO tSolucion (ID, Solución, Uso) VALUES ('14', 'Hidroquinoa', 'Agente despigmentante utilizado en tratamientos para aclarar la piel.');
INSERT INTO tSolucion (ID, Solución, Uso) VALUES ('15', 'Ciclobenzaprina', 'Actúa directamente en las células musculares para reducir la tensión y el dolor asociado con lesiones musculares.');
INSERT INTO tSolucion (ID, Solución, Uso) VALUES ('16', 'Metocarbamol', 'Relajante muscular de acción central utilizado para aliviar espasmos musculares y dolor asociado con lesiones musculares.');