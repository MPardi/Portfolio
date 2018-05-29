//
//  StartSplash.swift
//  LunarLanderGame
//
//  Created by Michael Pardi on 11/21/16.
//  Copyright © 2016 Michael Pardi. All rights reserved.
//

import Cocoa
import SpriteKit

class StartSplash: SKScene {
    var contentsCreated = false
    var clickCount = 0
    
    override func didMove(to view: SKView) {
        backgroundColor = SKColor.red
        scaleMode = .aspectFit
        if contentsCreated == false {
            createSceneContents()
            contentsCreated = true
        }
    }
    
    func createSceneContents() {
        let textNode1 = SKLabelNode(fontNamed: "Futura Condensed ExtraBold")
        let label: String = "Welcome to Lunar Lander!"
        textNode1.text = label
        textNode1.fontSize = 72
        textNode1.position = CGPoint(x: size.width/2.0, y: size.height/2.0)
        textNode1.name = "HelloText"
        addChild(textNode1)
        
        let textNode2 = SKLabelNode(fontNamed: "Futura Condensed ExtraBold")
        textNode2.text = "The Goal is to Land with the Highest Score"
        textNode2.fontSize = 50
        textNode2.position = CGPoint(x: size.width / 2.0, y: size.height / 2.0 - 80)
        textNode2.name = "GoalText1"
        addChild(textNode2)
        
        let textNode3 = SKLabelNode(fontNamed: "Futura Condensed ExtraBold")
        textNode3.text = "Before it gets to Zero!"
        textNode3.fontSize = 50
        textNode3.position = CGPoint(x: size.width / 2.0, y: size.height / 2.0 - 150)
        textNode3.name = "GoalText2"
        addChild(textNode3)
    }
    
    override func mouseDown(with event: NSEvent) {
        //Multi-threaded, so the actions will run at the same time as our print statement.
        clickCount += 1
        if clickCount == 1 {
            if let node = childNode(withName: "HelloText") {
                let moveUp = SKAction.moveBy(x: 0.0, y: 100.0, duration: 1.0)
                let zoom = SKAction.scale(to: 1.5, duration: 1.0)
                let pause = SKAction.wait(forDuration: 0.5)
                let fadeAway = SKAction.fadeOut(withDuration: 0.25)
                let remove = SKAction.removeFromParent()
                let sequence = SKAction.sequence([moveUp, zoom, pause, fadeAway, remove])
                
                node.run(sequence, completion: {
                let newScene = LanderScene(size: self.size)
                let doors = SKTransition.doorsOpenVertical(withDuration: 0.5)
                self.view?.presentScene(newScene, transition: doors)
                })
            }
            
            if let node = childNode(withName: "GoalText1") {
                let moveUp = SKAction.moveBy(x: 0.0, y: -100.0, duration: 1.0)
                let zoom = SKAction.scale(to: 1.5, duration: 1.0)
                let pause = SKAction.wait(forDuration: 0.5)
                let fadeAway = SKAction.fadeOut(withDuration: 0.25)
                let remove = SKAction.removeFromParent()
                let sequence = SKAction.sequence([moveUp, zoom, pause, fadeAway, remove])
                
                node.run(sequence, completion: {
                    let newScene = LanderScene(size: self.size)
                    let doors = SKTransition.doorsOpenVertical(withDuration: 0.5)
                    self.view?.presentScene(newScene, transition: doors)
                })
            }
            
            if let node = childNode(withName: "GoalText2") {
                let moveUp = SKAction.moveBy(x: 0.0, y: -125.0, duration: 1.0)
                let zoom = SKAction.scale(to: 1.5, duration: 1.0)
                let pause = SKAction.wait(forDuration: 0.5)
                let fadeAway = SKAction.fadeOut(withDuration: 0.25)
                let remove = SKAction.removeFromParent()
                let sequence = SKAction.sequence([moveUp, zoom, pause, fadeAway, remove])
                
                node.run(sequence, completion: {
                    let newScene = LanderScene(size: self.size)
                    let doors = SKTransition.doorsOpenVertical(withDuration: 0.5)
                    self.view?.presentScene(newScene, transition: doors)
                })
            }
        }
    }
}
