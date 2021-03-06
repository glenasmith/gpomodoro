

class GpomodoroController {
    // these will be injected by Griffon
    def model
    def view

    void mvcGroupInit(Map args) {
        // this method is called after model and view are injected
    }

    def startStopAction = { evt = null ->
	println view.dump()
	if (model.startLabel == "Start") {
	            model.startLabel = "Stop";
				Calendar finishCal = Calendar.getInstance();
	            if (model.finishTime == 0) {  // fresh timer	               
	               finishCal.add(Calendar.MINUTE, 25);
				} else {  // previously paused timer
					// Calendar only accepts ints to add...
				   int newDurationSecs = (model.finishTime - model.pauseTime) / 1000
				   finishCal.add(Calendar.SECOND, newDurationSecs)
				}
	            model.finishTime = finishCal.getTimeInMillis();	            
	            model.timer = new java.util.Timer()
				def myTask = {
					int minutes
					int seconds
					long millis = model.finishTime - System.currentTimeMillis()
					if (millis > 0) {
		            	seconds = (int)(millis/1000)
		            	minutes = seconds/60
		            	seconds = seconds % 60
					} else {
						minutes = seconds = 0
					}
		            model.timeRemaining = String.format("%d:%02d", minutes, seconds)
				}
	            model.timer.schedule(myTask as TimerTask, 200, 200)
	        } else {
	            model.startLabel = "Start"
				model.pauseTime = System.currentTimeMillis()
	            model.timer.cancel()
	        }
	
	}
    def resetAction = { evt = null ->
	
		model.finishTime = 0
		model.pauseTime = 0
		if (model.timer != null)
			model.timer.cancel()
		model.startLabel = "Start"
		model.timeRemaining = "25:00"
	
    }

    
}