# monitoreohabit
En este proyecto esta el codigo fuente para la aplicacion de monitoreo de sensores para realizar conteo de personas que ingresan a una habitación de hotel mediante sensore controlados por un NodeMCU y visualizados los datos en una app movil android.

Tambien se encuentra en la carpeta build el apk listo para instalar

El sistema consta de un un sensor thermal MEMS de Omron, D6T-44L_06 que entrega como salida una matriz de 4x4 de temperaturas, esta información se envia a una base de datos de firebase mediante un modulo NodeMCU que se conecta mediate la red wifi.
La información del sensor es visualizada en una app android. La platilla de diseño de la app utiliza viewpager de material design.
