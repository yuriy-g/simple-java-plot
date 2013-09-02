package com.github.plot;

import java.awt.Color;
import java.io.IOException;

import com.github.plot.Plot;

/*
 * To demonstrate:
 * 		- plot configuring
 * 		- legend types
 * 		- axis types
 *      - grid
 *      - series: line/marker
 */
public class PlotDemo {
	
	private static final String HOSTNAME = "host.org";
	
	private static final java.util.Calendar cal = java.util.Calendar.getInstance(); 
	
	private static final double[] DT = new double[9];
	
	static {
		cal.set(2222, 01, 01, 22, 22, 22);
		DT[0] = cal.getTimeInMillis();
		cal.set(2222, 01, 01, 22, 22, 52);
		DT[1] = cal.getTimeInMillis();
		cal.set(2222, 01, 01, 22, 23, 22);
		DT[2] = cal.getTimeInMillis();
		cal.set(2222, 01, 01, 22, 23, 52);
		DT[3] = cal.getTimeInMillis();
		cal.set(2222, 01, 01, 22, 24, 22);
		DT[4] = cal.getTimeInMillis();
		cal.set(2222, 01, 01, 22, 24, 52);
		DT[5] = cal.getTimeInMillis();
		cal.set(2222, 01, 01, 22, 25, 22);
		DT[6] = cal.getTimeInMillis();
		cal.set(2222, 01, 01, 22, 25, 52);
		DT[7] = cal.getTimeInMillis();
		cal.set(2222, 01, 01, 22, 35, 52);
		DT[8] = cal.getTimeInMillis();
	}
	
	public static void main(String[] args) throws IOException {
		Plot plot = Plot.plot(Plot.plotOpts().
				title("CPU/Memory (" + HOSTNAME + ")").
				width(1000).
				height(600).
				legend(Plot.LegendFormat.RIGHT)).	
			xAxis("t", Plot.axisOpts().
				format(Plot.AxisFormat.TIME_HMS)).
			yAxis("%", Plot.axisOpts().
				range(0, 100)).
			yAxis("bytes", Plot.axisOpts().
				format(Plot.AxisFormat.NUMBER_KGM)).
			series("CPU 1", Plot.data().
				xy(DT[0], 61).
				xy(DT[1], 74).
				xy(DT[2], 73).
				xy(DT[3], 76).
				xy(DT[4], 80).
				xy(DT[5], 75).
				xy(DT[6], 64).
				xy(DT[7], 60),
				Plot.seriesOpts().
					lineWidth(3).
					marker(Plot.Marker.NONE).
					color(Color.GREEN).
					yAxis("%")).
			series("CPU 2", Plot.data().
				xy(DT[2], 51).
				xy(DT[3], 59).
				xy(DT[4], 53).
				xy(DT[5], 55),
				Plot.seriesOpts().
					marker(Plot.Marker.CIRCLE).
					color(Color.BLUE).
					yAxis("%")).
			series("Memory 1", Plot.data().
				xy(DT[2], 52366224).
				xy(DT[3], 52266224).
				xy(DT[4], 55366224).
				xy(DT[5], 56566224).
				xy(DT[6], 54366224).
				xy(DT[7], 53333333),
				Plot.seriesOpts().
					marker(Plot.Marker.DIAMOND).
					markerColor(Color.GREEN).
					color(Color.BLACK).
					yAxis("y2")).
			series("Memory 2", Plot.data().
				xy(DT[0], 47366224).
				xy(DT[1], 46266224).
				xy(DT[2], 47366224).
				xy(DT[3], 50566224).
				xy(DT[4], 49366224).
				xy(DT[5], 46333333).
				xy(DT[6], 44444444),
				Plot.seriesOpts().
					marker(Plot.Marker.SQUARE).
					markerColor(Color.CYAN).
					color(Color.BLACK).
					yAxis("y2"));
		
		plot.save("sample_legend_right", "png");
		plot.opts().legend(Plot.LegendFormat.NONE);
		plot.save("sample_legend_none", "png");
		plot.opts().legend(Plot.LegendFormat.TOP);
		plot.save("sample_legend_top", "png");
		plot.opts().legend(Plot.LegendFormat.BOTTOM);
		plot.save("sample_legend_bottom", "png");
		plot.opts().gridColor(Color.WHITE);
		plot.save("sample_no_grid", "png");
		
		plot.opts().gridColor(Color.GRAY);
		plot.
			xAxis("t2", Plot.axisOpts().
				range(DT[1], DT[8]).
				format(Plot.AxisFormat.TIME_HMS)).
			series("CPU 2", Plot.data().
				xy(DT[2], 17).
				xy(DT[3], 25).
				xy(DT[4], 22).
				xy(DT[5], 28),
				Plot.seriesOpts().
					marker(Plot.Marker.CIRCLE).
					color(Color.RED).
					yAxis("%"));
		plot.save("sample_changed_series", "png");
	}

	// TODO: legend multiple axis
}