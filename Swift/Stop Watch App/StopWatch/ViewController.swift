//
//  ViewController.swift
//  StopWatch
//
//  Created by student on 9/15/16.
//  Copyright © 2016 Michael Pardi. All rights reserved.
//

import Cocoa

class ViewController: NSViewController {

    @IBOutlet weak var clockLabel: NSTextField!
    
    @IBOutlet weak var timerLabel: NSTextField!
    
    @IBOutlet weak var startButton: NSButton!
    
    @IBOutlet weak var lapLabel: NSTextField!
    
    var stopWatchTimer: NSTimer? = nil
    
    var appStartupTime: NSDate = NSDate()
    
    var isTimerOn = false
    
    var buttonCount = 0
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        updateTime()
        
        NSTimer.scheduledTimerWithTimeInterval(1.0, target: self, selector: #selector(ViewController.updateTime), userInfo: nil, repeats: true)
    }

    override var representedObject: AnyObject? {
        didSet {
        // Update the view, if already loaded.
        }
    }
    
    func updateTime() {
        let now = NSDate();
        let formatter = NSDateFormatter()
        formatter.dateStyle = .NoStyle
        formatter.timeStyle = .MediumStyle
        clockLabel.stringValue = formatter.stringFromDate(now)
    }
    
    func updateStopWatch(push: NSDate) {
        let now = NSDate()
        let timeFormatter = NSNumberFormatter()
        timeFormatter.numberStyle = NSNumberFormatterStyle.DecimalStyle
        timeFormatter.maximumFractionDigits = 2
        timeFormatter.minimumFractionDigits = 2
        let timeSinceStartup = timeFormatter.stringFromNumber(now.timeIntervalSinceDate(appStartupTime))
        timerLabel.stringValue = timeSinceStartup!
    }

    @IBAction func startButton(sender: NSDate) {
        if buttonCount < 1 {
            appStartupTime = NSDate()
        }
        if let timer = stopWatchTimer {
            timer.invalidate()
            stopWatchTimer = nil
            startButton.title = "Start"
            isTimerOn = false
        }
        else {
            stopWatchTimer = NSTimer.scheduledTimerWithTimeInterval(0.01, target: self, selector: #selector(ViewController.updateStopWatch), userInfo: nil, repeats: true)
            startButton.title = "Stop"
            isTimerOn = true
        }
        buttonCount += 1
    }

    @IBAction func resetButton(sender: AnyObject) {
        buttonCount = 0
        timerLabel.stringValue = " "
        stopWatchTimer = nil
    }
    
    @IBAction func lapButton(sender: AnyObject) {
        let now = NSDate()
        let timeFormatter = NSNumberFormatter()
        timeFormatter.numberStyle = NSNumberFormatterStyle.DecimalStyle
        timeFormatter.maximumFractionDigits = 2
        timeFormatter.minimumFractionDigits = 2
        let timeSinceStartup = timeFormatter.stringFromNumber(now.timeIntervalSinceDate(appStartupTime))
        lapLabel.stringValue = timeSinceStartup!
    }
}

