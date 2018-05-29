//
//  ViewController.swift
//  ProjectThree
//
//  Created by Michael Pardi on 4/24/17.
//  Copyright © 2017 MichaelPardi. All rights reserved.
//

import UIKit
import Foundation

class ViewController: UIViewController {
    private var controller: GameController
    
    let color = Colors()
    
    var timer: Timer?
    
    required init?(coder aDecoder: NSCoder) {
        controller = GameController()
        super.init(coder: aDecoder)
    }
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        refresh()
        
        startTimer()
        
        let level = Level()
        
        let gameView = UIView(frame: CGRect(x: 0, y: 0, width: ScreenWidth, height: ScreenHeight))
        
        self.view.addSubview(gameView)
        controller.gameView = gameView
        
        let gameDisplayView = GameInfoDisplayView(frame: CGRect(x: 40.0, y: 0.0, width: ScreenWidth, height: ScreenHeight))
        self.view.addSubview(gameDisplayView)
        controller.gameDisplay = gameDisplayView
        
        controller.level = level
        controller.dealRandomWord()
        
        let button = UIButton(frame: CGRect(x: ScreenWidth / 2.0, y: ScreenHeight / 2.0, width: 215, height: 50))
        button.center = CGPoint(x: ScreenWidth / 2.0, y: ScreenHeight / 2.0 + 75.0)
        button.backgroundColor = UIColor(red: 244.0 / 255.0, green: 179.0 / 255.0, blue: 80.0 / 255.0, alpha: 1.0)
        button.layer.masksToBounds = true
        button.layer.cornerRadius = 5.0
        button.titleLabel?.font = UIFont(name: "Futura", size: 20)
        button.setTitleColor(.black, for: .normal)
        button.setTitle("Submit Tiles", for: .normal)
        button.addTarget(self, action: #selector(buttonAction), for: .touchUpInside)
        button.setTitleColor(.red, for: .highlighted)
        
        self.view.addSubview(button)
        
//        self.view.insertSubview(button, belowSubview: gameView)
        self.view.insertSubview(gameDisplayView, belowSubview: gameView)
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func refresh() {
        view.backgroundColor = UIColor.clear
        let backgroundLayer = color.gl
        backgroundLayer.frame = view.frame
        view.layer.insertSublayer(backgroundLayer, at: 0)
    }
    
    override var prefersStatusBarHidden : Bool {
        return true
    }
    
    func buttonAction(sender: UIButton!) {
        var wasFound = false
        
        var alertController: UIAlertController!
        
        if !controller.targetWords.isEmpty {
            let targetString = String(controller.targetWords).lowercased()
            
            if targetString.characters.count > 1 {
                print(targetString)
            
                var total = 0
                
                for words in controller.wordList {
                    if targetString == words {
                        print("Word exists!")
                        
                        wasFound = true
                        break
                    }
                    else {
                        wasFound = false
                    }
                    total = total + 1
                }
                print(total)
                
                if wasFound {
                    controller.data.points += targetString.characters.count * controller.level.pointsPerTile
//                    controller.gameDisplay.gamePoints.value = controller.data.points
                    controller.gameDisplay.gamePoints.setValue(newValue: controller.data.points, duration: 0.5)
                    
                    controller.stopClock()
                    
                    controller.audioCont.playEffect(name: winSound)
                    
                    alertController = UIAlertController(title: "The word exists!", message: "You've been awarded \(controller.data.points) points for a word that contains \(targetString.characters.count) letters", preferredStyle: .alert)
                    
                    let newRound = UIAlertAction(title: "New Round", style: .default) { (action) -> Void in
                        self.controller.clearBoard()
                        
                        self.controller.dealRandomWord()
                    }
                    
                    alertController.addAction(newRound)
                    
//                    alertController.addAction(UIAlertAction(title: "New Round", style: .default, handler: nil))
                    
                }
                else {
                    controller.data.points -= targetString.characters.count * controller.level.pointsPerTile
//                    controller.gameDisplay.gamePoints.value = controller.data.points
                    controller.gameDisplay.gamePoints.setValue(newValue: controller.data.points, duration: 0.25)
                    
                    controller.stopClock()
                    
                    controller.audioCont.playEffect(name: loseSound)
                    
                    alertController = UIAlertController(title: "The word doesn't exist!", message: "You've been penialized \(controller.data.points) points for a word that contains \(targetString.characters.count) letters", preferredStyle: .alert)
                    
                    let newRound = UIAlertAction(title: "New Round", style: .default) { (action) -> Void in
                        self.controller.clearBoard()
                        
                        self.controller.dealRandomWord()
                    }
                    
                    alertController.addAction(newRound)
                    
                }
                self.present(alertController, animated: true, completion: nil)
            }
        }
    }
    
    func startTimer() {
        timer = Timer.scheduledTimer(timeInterval: 1.0, target: self, selector: #selector(timeChecker(timer:)), userInfo: nil, repeats: true)
    }
    
    @objc func timeChecker(timer: Timer) {
        if controller.gameTime == 0 {
            let alertController = UIAlertController(title: "Out of Time", message: "You ran out of time!!", preferredStyle: .alert)
            
            let newRound = UIAlertAction(title: "New Round", style: .default) { (action) -> Void in
                self.controller.clearBoard()
                
                self.controller.dealRandomWord()
            }
            
            alertController.addAction(newRound)
            
            self.present(alertController, animated: true, completion: nil)
        }
    }
    
    
    
    
    
    
//    }
//    func readFile() {
//        if let path = Bundle.main.path(forResource: "words", ofType: "json") {
//            do {
//                let data = try String(contentsOfFile: path, encoding: .utf8)
//                let myStrings = data.components(separatedBy: "\",\"")
//                TextView.text = myStrings.joined(separator: ", ")
//            } catch {
//                print(error)
//            }
//        }
//    }
}

