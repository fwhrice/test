package com.playerMain;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;

public class Toturial {
	public static void main(String[] args) {
		boolean found = new NativeDiscovery().discover();
		System.out.println(found);
        System.out.println(LibVlc.INSTANCE.libvlc_get_version());
   }

} 
