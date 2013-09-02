simple-java-plot
================

Simple Java implementation of plot. No dependencies besides standard libraries. 1 source file.

Minimal example:

```Java
// configuring everything by default
Plot plot = Plot.plot(null).
	// setting data
	series(null, Plot.data().
		xy(1, 2).
		xy(3, 4), null);

// saving sample_minimal.png
plot.save("sample_minimal", "png");
```

Hello World
```Java
Plot plot = Plot.plot(Plot.plotOpts().
		title("Hello World").
		legend(Plot.LegendFormat.BOTTOM)).
	xAxis("x", Plot.axisOpts().
		range(0, 5)).
	yAxis("y", Plot.axisOpts().
		range(0, 5)).
	series("Data", Plot.data().
		xy(1, 2).
		xy(3, 4),
		Plot.seriesOpts().
			marker(Plot.Marker.DIAMOND).
			markerColor(Color.GREEN).
			color(Color.BLACK));

plot.save("sample_hello", "png");
```

