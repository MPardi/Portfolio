//
//  GameController.swift
//  ProjectThree
//
//  Created by Michael Pardi on 4/24/17.
//  Copyright © 2017 MichaelPardi. All rights reserved.
//

import UIKit

class GameController {
    var gameView: UIView!
    
    var wordList: [String]!
    
//    var attemptPoints = 0
    
    var data = GameData()
    
//    var randomLetters: [String]!
    
    var gameDisplay: GameInfoDisplayView!
    
    var level: Level!
    
    var tiles = [TileView]()
    
    var targ = [TargetView]()
    
    var targetWords: [Character]!
    
    var gameTime: Int = 0
    
    var audioCont: AudioController = AudioController()
    
    var timer: Timer?
    
    var onWordFound:( () -> ())!
    
    init() {
        do {
            self.wordList = try linesFromResource(fileName: "web2")
        }
        catch let error as NSError {
            print(error.localizedDescription)
        }
        catch let error {
            print(error)
        }
        
        self.wordList = wordList.map {
            $0.lowercased()
        }
        
        targetWords = []
        
//        self.audioCont = AudioController()
        self.audioCont.preloadAudioEffects(effectFileNames: AudioEffectFiles)
    }
    
    func randomNumber(minX:UInt32, maxX:UInt32) -> Int {
        let result = (arc4random() % (maxX - minX + 1)) + minX
        return Int(result)
    }
    
    func linesFromResource(fileName: String) throws -> [String] {
        guard let path = Bundle.main.path(forResource: fileName, ofType: nil) else {
            throw NSError(domain: NSCocoaErrorDomain, code: NSFileNoSuchFileError, userInfo: [ NSFilePathErrorKey : fileName ])
        }
        let content = try String(contentsOfFile: path, encoding: String.Encoding.utf8)
        return content.components(separatedBy: "\n")
    }
    
    func dealRandomWord() {
//        let alphabet: NSString = "abcdefghijklmnopqrstuvwxyz"
        var randomIndex: Int
        let alphabet: [Character] = ["A", "B", "C", "D", "E", "F", "G", "H",
                                  "I", "J", "K", "L", "M", "N", "O", "P",
                                  "Q", "R", "S", "T", "U", "V", "W", "X",
                                  "Y", "Z"]
        
        let len = UInt32(alphabet.count)
        
        let amount = arc4random_uniform(30) + 10
        
        var randomLetters = [Character]()
        
        var randomYRange: CGFloat
        
        
        for _ in 0 ..< amount {
            randomIndex = Int(arc4random_uniform(len))
            
            randomLetters.append(alphabet[randomIndex])
        }
        
        
        let tileSide = ceil(ScreenWidth * 0.7 / CGFloat(max(amount, 2))) - TileMargin
        
        
        //Need to fix spacing
        var xOffset = (ScreenWidth - CGFloat(max(amount, 20)) * (tileSide + TileMargin)) / 2.0 + 50
        
        xOffset += tileSide / 2.0
        
        tiles = []
        
        targ = []
        
        for (index, letter) in randomLetters.enumerated() {
            
            if letter != " " {
//                randomYRange = CGFloat((arc4random_uniform(30) + 60))
                
                randomYRange = CGFloat(randomNumber(minX: 0, maxX: 100))
                
                let tile = TileView(letter: letter, sideLength: tileSide)
                
                tile.center = CGPoint(x: xOffset + CGFloat(index)*(tileSide + TileMargin), y: ScreenHeight/4*3 + randomYRange)
                
                tile.randomize()
                
                tile.dragDelegate = self
                
                gameView.addSubview(tile)

                tiles.append(tile)
            }
        }
        
        let target = TargetView()
        target.center = CGPoint(x: ScreenWidth / 2.0, y: ScreenHeight - 700)
        
        gameView.addSubview(target)
        targ.append(target)
        
        self.gameView.sendSubview(toBack: target)
        
        self.startClock()
    }
    
    func placeTile(tileView: TileView) {
//        targetView.isMatched = true
        tileView.isMatched = true
        
        tileView.isUserInteractionEnabled = false
        
        targetWords.append(tileView.letter)
        
        print(targetWords)
        
        UIView.animate(withDuration: 0.35,
                                   delay:0.00,
                                   options:UIViewAnimationOptions.curveEaseOut,
                                   //4
            animations: {
//                tileView.center = target.center
                tileView.transform = .identity
        },
            completion: {
                (value:Bool) in
//                targetView.isHidden = true
        })
    }
    
    func startClock() {
        gameTime = level.levelTime
        gameDisplay.clock.setSeconds(seconds: gameTime)
        
        timer = Timer.scheduledTimer(timeInterval: 1.0, target: self, selector: #selector(GameController.tick(timer:)), userInfo: nil, repeats: true)
    }
    
    func stopClock() {
        timer?.invalidate()
        timer = nil
    }
    
    @objc func tick(timer: Timer) {
        gameTime -= 1
        gameDisplay.clock.setSeconds(seconds: gameTime)
        
        if gameTime == 0 {
            self.stopClock()
        }
    }
    
    func clearBoard() {
        tiles.removeAll(keepingCapacity: false)
        targ.removeAll(keepingCapacity: false)
        
        for view in gameView.subviews  {
            view.removeFromSuperview()
        }
    }
    
//    func buttonAdd() {
//        let button = UIButton(frame: CGRect(x: ScreenWidth / 2.0, y: ScreenHeight / 2.0, width: 215, height: 50))
//        button.center = CGPoint(x: ScreenWidth / 2.0, y: ScreenHeight / 2.0 + 35.0)
//        button.backgroundColor = UIColor(red: 244.0 / 255.0, green: 179.0 / 255.0, blue: 80.0 / 255.0, alpha: 1.0)
//        button.layer.masksToBounds = true
//        button.layer.cornerRadius = 5.0
//        button.titleLabel?.font = UIFont(name: "Futura", size: 20)
//        button.setTitleColor(.black, for: .normal)
//        button.setTitle("Submit Tiles", for: .normal)
//        button.addTarget(self, action: #selector(buttonAction), for: .touchUpInside)
//        
//        self.gameView.addSubview(button)
//    }
//    
//    @objc func buttonAction() {
//        var wasFound = false
//        
//        var alertController: UIAlertController!
//        
//        if !targetWords.isEmpty {
//            let targetString = String(targetWords).lowercased()
//            
//            if targetString.characters.count > 1 {
//                print(targetString)
//                
//                var total = 0
//                
//                for words in wordList {
//                    if targetString == words {
//                        print("Word exists!")
//                        
//                        wasFound = true
//                        break
//                    }
//                    else {
//                        wasFound = false
//                    }
//                    total = total + 1
//                }
//                print(total)
//                
//                if wasFound {
//                    data.points += targetString.characters.count * level.pointsPerTile
//                    //                    controller.gameDisplay.gamePoints.value = controller.data.points
//                    gameDisplay.gamePoints.setValue(newValue: data.points, duration: 0.5)
//                    
//                    stopClock()
//                    
//                    alertController = UIAlertController(title: "The word exists!", message: "You've been awarded \(data.points) points for a word that contains \(targetString.characters.count) letters", preferredStyle: .alert)
//                    
//                    alertController.addAction(UIAlertAction(title: "New Round", style: .default, handler: nil))
//                    alertController.addAction(UIAlertAction(title: "Quit", style: .default, handler: nil))
//                    
//                }
//                else {
//                    data.points -= targetString.characters.count * level.pointsPerTile
//                    //                    controller.gameDisplay.gamePoints.value = controller.data.points
//                    gameDisplay.gamePoints.setValue(newValue: data.points, duration: 0.25)
//                    
//                    stopClock()
//                    
////                    gameView.viewDidLoad()
//                    
//                }
////                self.present(alertController, animated: true, completion: nil)
//            }
//        }
//    }
    
    
}

extension GameController:TileDragDelegateProtocol {
    func tileView(tileView: TileView, didDragToPoint point: CGPoint) {
        var targetWord: [Character] = []
        
        
        for tv in targ {
            if tv.frame.contains(point) && !tv.isMatched {
                placeTile(tileView: tileView)
                targetWord.append(tileView.letter)
                
                self.audioCont.playEffect(name: dropSound)
                
                break
            }
        }
        
//        if let targetView != targetView {
//            
////            if targetView.letter == tileView.letter {
//            
//                //3
//                print("Success! You should place the tile here!")
//                
//                //more stuff to do on success here
//                
//                print("Check if the player has completed the phrase")
//            }
//        else {
//                
//                //4
//                print("Failure. Let the player know this tile doesn't belong here")
//                
//                //more stuff to do on failure here
//            }
    }
}
