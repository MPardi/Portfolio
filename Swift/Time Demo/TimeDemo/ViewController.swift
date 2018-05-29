//
//  ViewController.swift
//  TimeDemo
//
//  Created by Michael Pardi on 9/7/16.
//  Copyright © 2016 Michael Pardi. All rights reserved.
//
//  Figure out a way to test weather the stop watch is running or not, a boolean would be good.
//  Get timer, lap
import Cocoa

class ViewController: NSViewController {
    
    @IBOutlet weak var startButton: NSButton!

    @IBOutlet weak var clockLabel: NSTextFieldCell!
    
    var appStartupTime: NSDate = NSDate()
    
    var stopWatchTimer: NSTimer? = nil
    
    @IBOutlet weak var timerOutlet: NSTextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        
        // Formats the NSDate output to display as the time format and sets it to print in the label we added.
        updateTime()
        
        NSTimer.scheduledTimerWithTimeInterval(1.0, target: self, selector: #selector(ViewController.updateTime), userInfo: nil, repeats: true)
    }

    override var representedObject: AnyObject? {
        didSet {
        // Update the view, if already loaded.
        }
    }
    
    @IBAction func startButton(sender: AnyObject) {
        //Something like this should be made to get the lap information
        if let timer = stopWatchTimer {
            //This happens when there is a timer object
            timer.invalidate()
            stopWatchTimer = nil
            startButton.title = "Start"
        }
        else {
            //This happens when there is NOT a timer object
         stopWatchTimer = NSTimer.scheduledTimerWithTimeInterval(0.1, target: self, selector: #selector(ViewController.updateStopWatch), userInfo: nil, repeats: true)
             startButton.title = "Stop"
        }
    }
    
    func updateTime() {
        let now = NSDate();
        let formatter = NSDateFormatter()
        formatter.dateStyle = .NoStyle
        formatter.timeStyle = .MediumStyle
        clockLabel.stringValue = formatter.stringFromDate(now)
    }
    
    func updateStopWatch() {
        // Try using this for the timer part of this program, in it's own method.
        let now = NSDate()
        let timeFormatter = NSNumberFormatter()
        timeFormatter.numberStyle = NSNumberFormatterStyle.DecimalStyle
        timeFormatter.maximumFractionDigits = 2
        timeFormatter.minimumFractionDigits = 2
        let timeSinceStartup = timeFormatter.stringFromNumber(now.timeIntervalSinceDate(appStartupTime))!
        timerOutlet.stringValue = timeSinceStartup
    }
    
    @IBAction func resetButton(sender: AnyObject) {
        
    }
    
    
    @IBAction func lapButton(sender: AnyObject) {
        
    }
    
}

