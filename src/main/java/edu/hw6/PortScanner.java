package edu.hw6;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PortScanner {

    private PortScanner() {
    }

    private static final Logger LOGGER = Logger.getLogger(PortScanner.class.getName());


    @SuppressWarnings("MagicNumber")
    public static void run() {
        int[] ports =
            {135, 137, 138, 139, 445, 843, 1900, 3702, 5040, 5050, 5353, 5355,
                5939, 6463, 6942, 17500, 17600, 27017, 42420};
        //CHECKSTYLE:OFF: MultipleStringLiterals
        String[] services = {"EPMAP", "Служба имен NetBIOS",
            "Служба датаграмм NetBIOS", "Служба сеансов NetBIOS",
            "Microsoft-DS Active Directory",
            "Adobe Flash", "Simple Service Discovery Protocol (SSDP)",
            "Динамическое обнаружение веб-служб", "", "",
            "Многоадресный DNS",
            "Link-Local Multicast Name Resolution (LLMNR)", "", "", "", "Dropbox",
            "Dropbox", "", "MongoDB", ""};
        //CHECKSTYLE:ON: MultipleStringLiterals
        Map<Integer, String> portMap = new HashMap<>();
        for (int i = 0; i < ports.length; i++) {
            portMap.put(ports[i], services[i]);
        }
        //CHECKSTYLE:OFF: MultipleStringLiterals
        for (int port : ports) {
            try {
                // TCP
                try (ServerSocket serverSocket = new ServerSocket(port)) {
                    LOGGER.log(Level.INFO, "TCP port " + port + " (" + portMap.get(port) + ") is open");
                } catch (IOException e) {
                    LOGGER.log(Level.INFO, "TCP port " + port + " (" + portMap.get(port) + ") is used");
                }

                // UDP
                try (DatagramSocket datagramSocket = new DatagramSocket(port)) {
                    LOGGER.log(Level.INFO, "UDP port " + port + " (" + portMap.get(port) + ") is open");
                } catch (IOException e) {
                    LOGGER.log(Level.INFO, "UDP port " + port + " (" + portMap.get(port) + ") is used");
                }

            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Failed", e);
            }
        }
        //CHECKSTYLE:ON: MultipleStringLiterals
    }
}
