application(title:'gpomodoro',  /*size:[320,480], location:[50,50],*/ pack:true, locationByPlatform:true) {
    // add content here
	panel() {
		borderLayout()
		panel(constraints: CENTER) {
	    	label(text:bind {model.timeRemaining}, 
				font: new java.awt.Font("Arial", java.awt.Font.BOLD, 48))
		}
		panel(constraints: SOUTH) {
			flowLayout()
			button( id: 'start', text: bind {model.startLabel}, actionPerformed:controller.startStopAction )
		    button( id: 'reset', text: 'Reset', actionPerformed:controller.resetAction )
		}
	}
}