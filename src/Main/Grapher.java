package src.Main;

import org.jfree.chart.ChartFactory;

import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.general.SeriesException;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Vector;

public class Grapher {

	/**
	 * makes a stock price graph over a specific given time period
	 * @param vals stock price values
	 * @param dates range of dates
	 * @param name stock ticker
	 */
	
	public static void makeGraph(Vector<Double> vals, Vector<Long> dates, String name) {
		XYSeries series = new XYSeries("Price");
		addDates(series, vals, dates);
		System.out.println(series.getMinY());
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series);
		
		JFreeChart linechart = ChartFactory.createXYLineChart(name,"Date (Millis since 1/1/1970)","Price",dataset);
		XYPlot plot = linechart.getXYPlot(); 
		
		setRange(plot, series);
		
		saveChart(plot);
		
	}
	
	/**
	 * adds dates and values to the series
	 * @param series of dates and values
	 * @param vals stock price values
	 * @param dates range of dates
	 */
	public static void addDates(XYSeries series, Vector<Double> vals, Vector<Long> dates) {
		for (int i =0; i<vals.size(); i++) {
			try {
			series.add(dates.get(i),vals.get(i));
			}
			catch(SeriesException e) {
				continue;
			}
		}
	}
	
	/**
	 * prompts the user and saves graph as a png file
	 * @param plot the stock price graph
	 */
	public static void saveChart(XYPlot plot) {
		System.out.println("Enter the name of the file you would like to save to");
		String file = UI.takeUserInput();
		try {
			ChartUtils.saveChartAsPNG(new File(file+".png"), plot.getChart(), 900, 800);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * sets the ranges for the graph
	 * @param plot the stock price graph
	 * @param series the series of dates and values
	 */
	public static void setRange(XYPlot plot, XYSeries series) {
		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		double min = series.getMinY()-10;
		if (min < 0) {
			min = 0;
		}
		rangeAxis.setRange(min, series.getMaxY()+10);
		plot.setRangeAxis(0,rangeAxis);
	}
	
	/**
	 * calls the API and makes calls to extract data and make the graph
	 * @param j  the JSON Object for the stock
	 * @param name the stock ticker name
	 */
	public static void parseData(JSONObject j, String name) {
		JSONArray vals1 = (JSONArray) j.get("c");
		JSONArray dates1 = (JSONArray) j.get("t");
		Vector<Double> vals = new Vector<Double>();
		Vector<Long> dates = new Vector<Long>();
		
		extractValues(vals1, dates1, vals, dates);
		
		makeGraph(vals,dates, name);
		
	}
	
	
	/**
	 * extracts stock price values over a specific date range
	 * @param vals1 JSON Array of stock values
	 * @param dates1 JSON Array of dates
	 * @param vals Vector to hold stock values
	 * @param dates Vector to hold dates
	 */
	public static void extractValues(JSONArray vals1, JSONArray dates1, Vector<Double> vals, Vector<Long> dates) {
		for (int i = 0; i < vals1.size(); i++){	
			try {
			double val = ((double) vals1.get(i));
			}
			catch(ClassCastException e) {
				continue;
			}
			double val = ((double) vals1.get(i));
			Long d = (Long) dates1.get(i);
			
			vals.add(val);
			dates.add(d);
			
		}
	}
	
	
}