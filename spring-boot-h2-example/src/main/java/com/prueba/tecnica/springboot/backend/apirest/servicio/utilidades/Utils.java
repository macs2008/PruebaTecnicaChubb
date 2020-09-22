package com.prueba.tecnica.springboot.backend.apirest.servicio.utilidades;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
	private final static Logger logger = Logger.getLogger(Utils.class.getName());
	
	/**
     * Convierte archivo codificado en Base 64 para guardarlo como un archvio en
     * disco
     *
     * @param archivoBase64
     * @param rutaArchivo
     * @throws java.io.FileNotFoundException
     */
    public static void escribirArchivoBase64AArchivoEnDisco(String archivoBase64, String rutaArchivo) throws FileNotFoundException, IOException {
        byte[] bytes = Base64.getDecoder().decode(archivoBase64);
        File outputFile = new File(rutaArchivo);
        
        try (FileOutputStream outputStream = new FileOutputStream(outputFile)) {
            outputStream.write(bytes);
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
    }
    
	public static boolean esNumerico(String source) {
		boolean esNumerico = true;
		
		for (int i = 0;i < source.length();i++) {
			if (!Character.isDigit(source.charAt(i))) {
				esNumerico = false;
				break;
			}
		}
		
		return esNumerico;
	}
	
	public static boolean esVacio(String cadena) {
		return cadena == null || cadena.equals("");
	}
	
	public static String obtenerFechaHoraStringMMDDAAAHHMMSS() {
		Calendar fecha = Calendar.getInstance();
		String anio = fecha.get(Calendar.YEAR) + "";
		String mes = (fecha.get(Calendar.MONTH) + 1) + "";
		String dia = fecha.get(Calendar.DAY_OF_MONTH) + "";
		String hora = fecha.get(Calendar.HOUR_OF_DAY) + "";
		String minuto = fecha.get(Calendar.MINUTE) + "";
		String segundo = fecha.get(Calendar.SECOND) + "";
		
		return (mes.length() == 1 ? "0" + mes : mes) + (dia.length() == 1 ? "0" + dia : dia) + anio + "_" + (hora.length() == 1 ? "0" + hora : hora) + (minuto.length() == 1 ? "0" + minuto : minuto) + (segundo.length() == 1 ? "0" + segundo : segundo);
	}
	
	/**
	 * Convierte un arreglo archivo a base64
	 * @param rutaArchivo
	 * @return String
	 * @throws java.lang.Exception
	 */
	public static String convertirArchivoABase64(String rutaArchivo) throws Exception {
		try {
			byte[] base64EncodedImage = convertirArchivoAByte(rutaArchivo);
			
			if (base64EncodedImage != null) {
				String imageBase64 = Base64.getEncoder().encodeToString(base64EncodedImage);
				
				if (imageBase64 != null && !imageBase64.trim().equals("")) {
					return imageBase64;
				} else {
					return null;
				}
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * Convierte un archivo de una ruta a un arreglo de byte
	 * @param rutaArchivo
	 * @return byte[]
	 * @throws java.lang.Exception
	 */
	public static byte[] convertirArchivoAByte(String rutaArchivo) throws Exception {
		File file = new File(rutaArchivo);
		
		if (file.exists()) {
			BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file));
			
			try {
				int lenght = (int) file.length();
				byte[] bytes = new byte[lenght];
				reader.read(bytes, 0, lenght);
				reader.close();
				return bytes;
			} catch (Exception e) {
				return null;
			} finally {
				reader.close();
			}
		} else {
			return null;
		}
	}
	
	/**
	 * sumarAniosFecha
	 * @param fecha
	 * @param anios
	 * @return la fecha con la suma de años
	 */
	public static String sumarAniosFecha(String fecha, int anios) {
		Date date = null;
		String conversion = null;
		
		try {
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			date = formato.parse(fecha);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.YEAR, anios);
			conversion = formato.format(calendar.getTime());
			SimpleDateFormat formatoSalida = new SimpleDateFormat("MM/dd/yyyy");
			Date fechaformato = formato.parse(conversion);
			String formatoFinal = formatoSalida.format(fechaformato);
			
			return formatoFinal;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return conversion;
	}
	
	/**
	 * sumarDiasFecha
	 * @param fecha
	 * @param dias
	 * @return una fecha con la suma de dias
	 */
	public static String sumarDiasFecha(String fecha, int dias) {
		Date date = null;
		String conversion = null;
		
		try {
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			date = formato.parse(fecha);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.DAY_OF_YEAR, dias);
			conversion = formato.format(calendar.getTime());
			
			SimpleDateFormat formatoSalida = new SimpleDateFormat("MM/dd/yyyy");
			Date fechaformato = formato.parse(conversion);
			String formatoFinal = formatoSalida.format(fechaformato);
			
			return formatoFinal;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return conversion;
	}
	
	/**
	 * comparacionFechas	
	 * compara dos fechas 
	 * @param fecha1
	 * @param fecha2
	 * @return devuelve true o false
	 */
	public static int comparacionFechas(String fecha1, String fecha2) {
		int comparacion = -1;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date date1 = sdf.parse(fecha1);
			Date date2 = sdf.parse(fecha2);
			comparacion = date1.compareTo(date2);
			
			return comparacion ;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return comparacion;
	}
	
	public static boolean validarFormatoFecha(String fecha) {
		try {
			SimpleDateFormat formato = new SimpleDateFormat("MM/dd/yyyy");
			formato.parse(fecha);
			return true;
		} catch (ParseException e) {
			return false;
		}	
	}
	
	public static String sumarDiasFechaFormato(String fecha, int dias) {
		Date date = null;
		String conversion = null;
		
		try {
			SimpleDateFormat formato = new SimpleDateFormat("MM/dd/yyyy");
			date = formato.parse(fecha);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.DAY_OF_YEAR, dias);
			conversion = formato.format(calendar.getTime());
			
			return conversion;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return conversion;
	}
	
	/**
	 * cambiarFormatoFecha
	 * @funcionalidad cambia de formato "MM/dd/yyyy" a "yyyy-MM-dd"
	 * @param fecha
	 * @return
	 */
	public static String cambiarFormatoFecha(String fecha) {
		String fechaFinal = "";
		
		try {
			SimpleDateFormat formato = new SimpleDateFormat("MM/dd/yyyy");
			Date date = formato.parse(fecha);
			SimpleDateFormat formatoFinal = new SimpleDateFormat("yyyy-MM-dd");
			fechaFinal = formatoFinal.format(date);
			return fechaFinal;
		} catch (ParseException e) {
			return fechaFinal;
		}	
	}
	
	/**
	 * comparacionFechasFormato
	 * @param fecha1
	 * @param fecha2
	 * @return
	 */
	public static int comparacionFechasFormato(String fecha1, String fecha2) {
		int comparacion = -1;
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		
		try {
			Date date1 = sdf.parse(fecha1);
			Date date2 = sdf.parse(fecha2);
			comparacion = date1.compareTo(date2);
			
			return comparacion ;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return comparacion;
	}
	/**
	 * convertirFecha
	 * @param fecha
	 * @return
	 */
	public static Date convertirFecha(String fecha) {
		Date date = null;
		
		try {
			SimpleDateFormat formato = new SimpleDateFormat("MM/dd/yyyy");
			date =formato.parse(fecha);
			return date;
		} catch (ParseException e) {
			return date;
		}	
	}
	/**
	 * validarMail
	 * @param email
	 * @return
	 */
	public static boolean validarMail(String email) {
        // Patron para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
        Matcher mather = pattern.matcher(email);
        return mather.find();
    }
	
	public static boolean eArchivoBase64AArchivoEnDisco(String archivoBase64, String rutaArchivo) throws FileNotFoundException, IOException {
       
        
        try  {
        	 byte[] bytes = Base64.getDecoder().decode(archivoBase64);
             File outputFile = new File(rutaArchivo);
        	FileOutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write(bytes);
            
            outputStream.close();
            return true;
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
		return false;
    }
	public  static String fechaHoy() {
		
		Date hoy = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = dateFormat.format(hoy);
		
		return strDate;
		
	}
	
	public static void borrarficheros (File directorio,  List<String> listanombres ){
		
		File[] ficheros = directorio.listFiles();
		
		for (File file : ficheros) {
			
			int index = file.toString().lastIndexOf("\\");
			
			String nombre = file.toString().substring(index+1);
			
			for (String nombreArchivos : listanombres) {
				
				if(nombreArchivos.equals(nombre)) {
					file.delete();
				}
			}	
		}	
	}
	/**
	 * convertirFechaADate
	 * @param fecha
	 * @return
	 */
	public static Date convertirFechaADate(String fecha) {
		Date date = null;
		
		try {
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			date =formato.parse(fecha);
			return date;
		} catch (ParseException e) {
			return date;
		}	
	}
}
