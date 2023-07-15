package com.masai.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.masai.model.Artist;
import com.masai.model.Artwork;

public class ArtistService {
	// Hint: Make use of Setter Injection to inject ArtworkMap and artistList.
	
	private Map<Artist, Artwork> artworkMap; // inject 4 entries with valid details

	private List<Artist> artistList; // inject List of 6 Artist object

	public void setArtworkMap(Map<Artist, Artwork> artworkMap) {
		this.artworkMap = artworkMap;
	}

	public void setArtistList(List<Artist> artistList) {
		this.artistList = artistList;
	}

	public void printArtworkMap() {
		// print all the artists and their artwork details from the artworkMap
		
		for(Map.Entry<Artist, Artwork> set : artworkMap.entrySet()) {
			System.out.println(set.getKey() +" "+set.getValue());
		}
	}

	public void printArtistList() {
		// sort the List of Artists according to the decreasing order of the
		// noOfArtworks Created
		// If the number of artworks is the same, then sort by age
		// print all the sorted Artist Details
		
		artistList.sort((a,b)->{
			if(a.getNoOfArtworksCreated() == b.getNoOfArtworksCreated()) {
				return a.getAge()-b.getAge();
			}
			return b.getNoOfArtworksCreated() - a.getNoOfArtworksCreated();
		});
		
		artistList.forEach(System.out::println);
		
	}

	public double averageAgeOfArtistsWithArtworks(int minArtworks) {
		// Calculate the average age of the artists who have created more than
		// 'minArtworks' artworks
		
		int articstAge = 0;
		int count = 0;
		
		for(Artist a : artistList) {
			if(a.getNoOfArtworksCreated() > minArtworks) {
				articstAge+=a.getAge();
				count++;
			}
		}
		return articstAge/count;
	}

	public List<Artist> topArtistsByArtworks(int n) {
		// Find the top 'n' artists based on the number of artworks created, and sort
		// them by age in case of a tie
		artistList.sort((a,b)->{
			if(a.getNoOfArtworksCreated() == b.getNoOfArtworksCreated()) {
				return a.getAge()-b.getAge();
			}
			return b.getNoOfArtworksCreated() - a.getNoOfArtworksCreated();
		});
		if(n>=artistList.size())return artistList;
		List<Artist> list = new ArrayList<>();
		for(int i=0;i<n;i++) {
			list.add(artistList.get(i));
		}
		return list;
	}

	public Map<Artist, Artwork> topArtworksByCreationTime(int n) {
		// Find the top 'n' artworks based on creation time, and return the artwork
		// information as a Map
		
		List<Map.Entry<Artist, Artwork>> list = new LinkedList<>(artworkMap.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<Artist, Artwork>>() {

			@Override
			public int compare(Entry<Artist, Artwork> o1, Entry<Artist, Artwork> o2) {
				return o2.getValue().getCreationTime() - o1.getValue().getCreationTime(); 
			}
			
		});
		
		Map<Artist, Artwork> temp = new LinkedHashMap<>();
		int count =0;
		for(Map.Entry<Artist, Artwork> set : list) {
			temp.put(set.getKey(), set.getValue());
			count++;
			if(count == n) break;
		}
		
		return temp;
		
		
		
	}

}
