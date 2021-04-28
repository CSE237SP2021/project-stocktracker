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

	public static void makeGraph(Vector<Double> vals, Vector<Long> dates, String name) {
		XYSeries series = new XYSeries("Price");
		addDates(series, vals, dates);
		System.out.println(series.getMinY());
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series);
		
		JFreeChart linechart = ChartFactory.createXYLineChart(name,"Date (Millis since 1/1/1970","Price",dataset);
		XYPlot plot = linechart.getXYPlot(); 
		
		setRange(plot, series);
		
		saveChart(plot);
		
	}
	
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
	
	public static void setRange(XYPlot plot, XYSeries series) {
		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		double min = series.getMinY()-10;
		if (min < 0) {
			min = 0;
		}
		rangeAxis.setRange(min, series.getMaxY()+10);
		plot.setRangeAxis(0,rangeAxis);
	}
	
	static void parseData(JSONObject j, String name) {
		JSONArray vals1 = (JSONArray) j.get("c");
		JSONArray dates1 = (JSONArray) j.get("t");
		Vector<Double> vals = new Vector<Double>();
		Vector<Long> dates = new Vector<Long>();
		
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
		makeGraph(vals,dates, name);
		
	}
	
}
