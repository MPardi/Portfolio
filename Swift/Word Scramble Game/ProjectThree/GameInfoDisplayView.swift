//
//  GameInfoDisplayView.swift
//  ProjectThree
//
//  Created by Michael Pardi on 5/5/17.
//  Copyright © 2017 MichaelPardi. All rights reserved.
//

import UIKit

class GameInfoDisplayView: UIView {
    var clock: ClockTimerView
    
    var gamePoints: ScoreView
    
    required init(coder aDecoder: NSCoder) {
        fatalError("Use init(frame: )")
    }
    
    override init(frame: CGRect) {
        self.clock = ClockTimerView(frame: CGRect(x: ScreenWidth / 2.0 - 125, y: 0, width: 300, height: 100))
//        self.clock.center = CGPoint(x: ScreenWidth / 2.0, y: ScreenHeight + 100)
        self.clock.setSeconds(seconds: 0)
        
        self.gamePoints = ScoreView(font: FontGameDisplay, frame: CGRect(x: ScreenWidth - 90.0, y: 15.0, width: 200.0, height: 70.0))
        gamePoints.textColor = UIColor(red: 0.38, green: 0.098, blue: 0.035, alpha: 1.0)
        gamePoints.value = 0
        
        super.init(frame: frame)
        
        self.addSubview(self.clock)
        
        self.addSubview(gamePoints)
        
        var pointsLabel = UILabel(frame: CGRect(x: ScreenWidth - 165.0, y: 15.0, width: 140.0, height: 70.0))
        pointsLabel.backgroundColor = UIColor.clear
        pointsLabel.font = FontGameDisplay
        pointsLabel.text = "Points:"
        self.addSubview(pointsLabel)
        self.isUserInteractionEnabled = false
    }

}
