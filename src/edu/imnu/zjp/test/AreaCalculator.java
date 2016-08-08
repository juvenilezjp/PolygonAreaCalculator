package edu.imnu.zjp.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/***
 *
 * @author imnujf
 *
 * @date 2016.8.7
 * 
 * @description This program is used for calculating the area of arbitrary polygon.
 * 				The theory evidence is from "Computational Geometry in C by Joseph O'Rourke" in page 20.
 */
public class AreaCalculator
{
	/***
	 * 
	 * @param x : Horizontal coordinates of the polygon
	 * @param y : Vertical coordinates of the polygon
	 * 
	 * @return area : area of the polygon
	 * 
	 * @hint x,y must be in order, and the number of x must larger than 3
	 * 
	 * */

	public static double Calculate(double[] x, double[] y)
	{
		double area = 0.0;
		double _sum = 0.0;
		
		int i=0;
		for (; i<x.length -1; i++)
		{
			_sum += (x[i] * y[i + 1] - x[i + 1] * y[i]);
		}
		area = (Math.abs(_sum + (x[i] * y[0]) - (x[0] * y[i]))) / 2.0;
        
		return area;
	}
	
	
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		
		double[] x = {};
		double[] y = {};
		
		
		// 1. read source data from "./Data/SampleInput"
		//    data format: x in first line, y in second line. 
		//    1, 1, 3, 3, 2
		//    1, 3, 3, 1, 2

		FileReader reader = new FileReader("./Data/SampleInput");
        BufferedReader br = new BufferedReader(reader);
        
        String str = null;
        ArrayList<String> sampleInput = new ArrayList<String>();
        
        while((str = br.readLine()) != null) {
        	  sampleInput.add(str);
        }
        br.close();
        reader.close();
        
        // 2. calculate the area.
        
        for (int i=0; i<sampleInput.size(); i = i+2)
        {
        	x = str2array(sampleInput.get(i));
        	y = str2array(sampleInput.get(i+1));
        	
        	System.out.println(Calculate(x, y));
        }

	}

	private static double[] str2array(String ss)
	{
		// TODO Auto-generated method stub
		
		String[] _s = ss.split(",");
		double[] _ret = new double[_s.length];
		
		for (int i=0; i<_s.length; i++)
		{
			_ret[i] = Double.valueOf(_s[i]);
		}
		
		return _ret;
	}

}
