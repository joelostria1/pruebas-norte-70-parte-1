SELECT l.Nombre, l.Editorial,p.fecha_prestamo,l.Dias_limite_prestamo
FROM Prestamo p 
INNER JOIN Alumno a ON p.id_alumno = a.id 
INNER JOIN Libro l ON l.id = p.id_libro  
WHERE a.Nombres = 'Sonia'
And p.entregado = false
AND DATE_ADD(p.fecha_prestamo,INTERVAL l.Dias_limite_prestamo DAY)< '2021-07-30'



Select * from Prestamo p 