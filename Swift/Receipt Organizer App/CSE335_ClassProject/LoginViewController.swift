//
//  LoginViewController.swift
//  CSE335_ClassProject
//
//  Created by Michael Pardi on 4/23/18.
//  Copyright © 2018 Michael Pardi. All rights reserved.
//

import UIKit
import CoreData

class LoginViewController: UIViewController {
    let context = (UIApplication.shared.delegate as! AppDelegate).persistentContainer.viewContext
    
    var fetchedResults = [Users]()

    @IBOutlet weak var nameField: UITextField!
    @IBOutlet weak var passwordField: UITextField!
    @IBOutlet weak var errorText: UILabel!
    @IBOutlet weak var loginImage: UIImageView! {
        didSet {
            loginImage.image = UIImage(named: "key.png")
        }
    }
    
    var loginSuccess: Bool = false
    
    override func viewDidLoad() {
        super.viewDidLoad()
        errorText.isHidden = true
        // Do any additional setup after loading the view.
    }
    
    override func viewDidAppear(_ animated: Bool) {
        loginSuccess = false
        errorText.isHidden = true
        initialDataCheck()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func initialDataCheck() {
        let fetchRequest = NSFetchRequest<NSFetchRequestResult>(entityName: "Users")
        var x = 0
        
        fetchedResults = ((try? context.fetch(fetchRequest)) as? [Users])!
        
        x = fetchedResults.count
    }
    
    func checkUser() {
        if (nameField.text == "" || passwordField.text == "") {
            errorText.text = "Please Enter Login Information"
            errorText.isHidden = false
            Timer.scheduledTimer(timeInterval: 3.0, target: self, selector: #selector(self.dismissError), userInfo: nil, repeats: false)
            return
        }
        
        for user in fetchedResults {
            if (nameField.text == user.username) {
                if (passwordField.text == user.password) {
                    loginSuccess = true
                }
            }
        }
        
        if !loginSuccess {
            errorText.text = "Incorrect Username or Password"
            errorText.isHidden = false
            Timer.scheduledTimer(timeInterval: 3.0, target: self, selector: #selector(self.dismissError), userInfo: nil, repeats: false)
        }
    }
    
    @objc func dismissError() {
        errorText.isHidden = true
    }
    
    override func shouldPerformSegue(withIdentifier identifier: String, sender: Any?) -> Bool {
        checkUser()
        
        if loginSuccess {
            return loginSuccess
        }
        
        return false
    }

    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if loginSuccess {
            if segue.identifier == "loginSuccessSegue" {
                if let homeVC = segue.destination as? ViewController {
                    homeVC.userLoggedIn = true
                    homeVC.userName = nameField.text!
                    print(homeVC.userLoggedIn)
                }
            }
        }
    }
    
}
