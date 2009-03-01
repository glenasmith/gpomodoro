import groovy.beans.Bindable

class GpomodoroModel {
   // @Bindable String propName
	@Bindable String timeRemaining = "25:00"
	@Bindable String startLabel = "Start"
	java.util.Timer timer = null

	long currTime = 0L
	long finishTime = 0L
	long pauseTime = 0L
	
}