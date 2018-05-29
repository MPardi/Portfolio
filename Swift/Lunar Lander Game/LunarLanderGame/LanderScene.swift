//
//  LanderScene.swift
//  LunarLanderGame
//
//  Created by Michael Pardi on 11/21/16.
//  Copyright © 2016 Michael Pardi. All rights reserved.
//

import Cocoa
import SpriteKit
import GameplayKit
import AVFoundation

class LanderScene: SKScene, SKPhysicsContactDelegate {
    var contentCreated = false
    var score = 3100
    var keyDown = 0
    let thruster = SKAction.playSoundFileNamed("Thruster.wav", waitForCompletion: false)
    
    var randomSource = GKLinearCongruentialRandomSource.sharedRandom()
    
    override func didMove(to view: SKView) {
        if contentCreated == false {
            createSceneContents()
            contentCreated = true
            physicsWorld.gravity = CGVector(dx: 0.0, dy: -0.2)
        }
    }
    
    func createSceneContents() {
        let bkgText = SKTexture(imageNamed: "starBackground.png")
        let background = SKSpriteNode(texture: bkgText, size: CGSize(width: frame.width, height: frame.height))
        background.position = CGPoint(x: frame.size.width / 2, y: frame.size.height / 2)
        addChild(background)
        scaleMode = .aspectFit
        
        let scoreNode = SKLabelNode(fontNamed: "Futura")
        scoreNode.text = "Score: 5000"
        scoreNode.fontSize = 42
        scoreNode.position = CGPoint(x: 20.0, y: size.height - 120.0)
        scoreNode.name = "ScoreLabel"
        scoreNode.zPosition = 20.0
        scoreNode.horizontalAlignmentMode = .left
        addChild(scoreNode)
        
        let scoreDrain = SKAction.sequence([SKAction.perform(#selector(LanderScene.scoreUpdate), onTarget: self),
                                            SKAction.wait(forDuration: 1.0, withRange: 0.35)])
        run(SKAction.repeatForever(scoreDrain))
        
        createLander()
        
        physicsWorld.contactDelegate = self
        
        createBackdrop()
    }
    
    func scoreUpdate() {
        score = score - 100
        print("Score = \(score)")
        if let scoreNode = childNode(withName: "ScoreLabel") as! SKLabelNode? {
            scoreNode.text = "Score: \(score)"
        }
        
    }
    
    func createLander() {
        let t1 = SKTexture(imageNamed: "Lander1.png")
        
        let lander = SKSpriteNode(texture: t1)
        lander.position = CGPoint(x: frame.midX, y: frame.midY)
        lander.zPosition = 10.0
        lander.size = CGSize(width: 71, height: 61)
        lander.name = "lander"
        lander.physicsBody = SKPhysicsBody(texture: t1, size: CGSize(width: 71, height: 61))
        
        lander.physicsBody?.usesPreciseCollisionDetection = true
        lander.physicsBody?.contactTestBitMask = 1
        
        addChild(lander)
    }
    
    func createBackdrop() {
        let floor = SKSpriteNode(color: SKColor.gray, size: CGSize(width: frame.width, height: 32.0))
        floor.position = CGPoint(x: frame.midX, y: 16.0)
        floor.physicsBody = SKPhysicsBody(rectangleOf: floor.size)
        floor.physicsBody?.isDynamic = false
        floor.name = "floor"
        addChild(floor)
        
        let groundGroup = SKSpriteNode()
        groundGroup.name = "groundGroup"
        
        let groundTexture = SKTexture(imageNamed: "LunarSurface2.png")
        
        let ground = SKSpriteNode(texture: groundTexture, size: CGSize(width: frame.width, height: 32.0))
        ground.position = CGPoint(x: frame.midX, y: 35.0)
        ground.name = "ground"
        ground.physicsBody = SKPhysicsBody(texture: groundTexture, size: CGSize(width: frame.width, height: 32.0))
        ground.physicsBody?.isDynamic = true
        ground.physicsBody?.usesPreciseCollisionDetection = true
        ground.physicsBody?.contactTestBitMask = 1
        ground.zPosition = 5.0
        groundGroup.addChild(ground)
        
        let padTexture = SKTexture(imageNamed: "LandingPad.png")
        let landingPad = SKSpriteNode(texture: padTexture, size: CGSize(width: 100.0, height: 75.0))
        landingPad.position = CGPoint(x: 150.0, y: 70.0)
        landingPad.name = "landingPad"
        landingPad.physicsBody = SKPhysicsBody(texture: padTexture, size: CGSize(width: 100.0, height: 75.0))
        landingPad.zPosition = 6.0
        groundGroup.addChild(landingPad)
        
        addChild(groundGroup)
    }
    
    override func keyDown(with event: NSEvent) {
        if event.keyCode == 126 {
            if let node = childNode(withName: "lander") {
                keyDown = keyDown + 1
                
                if keyDown == 1 {
                    let t1 = SKTexture(imageNamed: "Lander1.png")
                    let t2 = SKTexture(imageNamed: "Lander2.png")
                    let t3 = SKTexture(imageNamed: "Lander3.png")
                    let landerTextures = [t1, t2, t3]
                    
                    let animateLander = SKAction.animate(with: landerTextures, timePerFrame: 0.1)
                    
                    node.run(animateLander)
                    
                    node.run(thruster)
                }
                
                let up = CGVector(dx: 0.0, dy: 0.4)
                node.physicsBody?.applyImpulse(up)
            }
        }
        
        if event.keyCode == 123 {
            if let node = childNode(withName: "lander") {
                //let left = CGVector(M_PI/4.0)
                let left = CGVector(dx: -0.2, dy: 0.0)
                node.physicsBody?.applyImpulse(left)
                //let left = SKAction.rotate(byAngle: angle, duration: 0.5)
                //node.run(left)
                //node.zRotation += angle
            }
        }
        if event.keyCode == 124 {
            if let node = childNode(withName: "lander") {
                let right = CGVector(dx: 0.2, dy: 0.0)
                //let right = SKAction.rotate(byAngle: -angle, duration: 0.5)
                node.physicsBody?.applyImpulse(right)
                //node.zRotation -= angle
            }
        }
    }
    
    //Set angle to a variable, angle property, when engine is firing, using impulse, if you have an angle, you want to calculate the vetor and based on angle, change direction.
    //Use equation r* cos(angle) = x y = r * sin(angle) this will give you the x/y of vector, r can just be 1, depending on the impulse
    override func keyUp(with event: NSEvent) {
        if event.keyCode == 126 {
            if let node = childNode(withName: "lander") {
                keyDown = 0
                let t1 = SKTexture(imageNamed: "Lander1.png")
                let landerTextures = [t1]
                
                let animateLander = SKAction.animate(with: landerTextures, timePerFrame: 0.1)
                
                node.run(animateLander)
                node.removeAllActions()
                
            }
        }
    }
    
    func didBegin(_ contact: SKPhysicsContact) {
        if let node = childNode(withName: "lander") {
            
            if contact.bodyA.node?.name == "lander" && contact.bodyB.node?.name == "ground" {
                isPaused = true
                
                let startScene = CompleteSplash(size: self.size)
                let doors = SKTransition.doorsOpenVertical(withDuration: 0.5)
                self.view?.presentScene(startScene, transition: doors)
                
            }
            else if contact.bodyA.node?.name == "lander" && contact.bodyB.node?.name == "landingPad" && (node.physicsBody?.velocity.dy)! < 1.0 {
                isPaused = true
                
                let winScene = WinSplash(size: self.size)
                let doors = SKTransition.doorsOpenVertical(withDuration: 0.5)
                self.view?.presentScene(winScene, transition: doors)
            }
            else if contact.bodyA.node?.name == "lander" && contact.bodyB.node?.name == "landingPad" && (node.physicsBody?.velocity.dy)! > 1.0{
                isPaused = true
                
                let startScene = CompleteSplash(size: self.size)
                let doors = SKTransition.doorsOpenVertical(withDuration: 0.5)
                self.view?.presentScene(startScene, transition: doors)
            }
            else if score <= 0{
                isPaused = true
                
                let startScene = CompleteSplash(size: self.size)
                let doors = SKTransition.doorsOpenVertical(withDuration: 0.5)
                self.view?.presentScene(startScene, transition: doors)
            }
        }
    }
}
