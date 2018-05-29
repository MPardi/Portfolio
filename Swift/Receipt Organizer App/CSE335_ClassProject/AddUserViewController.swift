//
//  AddUserViewController.swift
//  CSE335_ClassProject
//
//  Created by Michael Pardi on 3/28/18.
//  Copyright © 2018 Michael Pardi. All rights reserved.
//

import UIKit
import CoreData

class AddUserViewController: UIViewController {
    
    let context = (UIApplication.shared.delegate as! AppDelegate).persistentContainer.viewContext
    
    @IBOutlet weak var nameField: UITextField!
    @IBOutlet weak var passwordFieldOne: UITextField!
    @IBOutlet weak var passwordFieldTwo: UITextField!
    @IBOutlet weak var addUserLogo: UIImageView! {
        didSet {
            addUserLogo.image = UIImage(named: "user.png")
        }
    }
    
    var userCreated: Bool = false
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // Do any additional setup after loading the view.
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "userCreatedSegue" {
            if let homeVC = segue.destination as? ViewController {
                homeVC.userWasCreated = true
            }
        }
    }

    override func shouldPerformSegue(withIdentifier identifier: String, sender: Any?) -> Bool {
        saveUser()
        
        if userCreated {
            return userCreated
        }
        
        return false
    }
    
    func saveUser() {
        if (nameField.text == "" || passwordFieldOne.text == "" || passwordFieldTwo.text == "") {

            print("You haven't filled out all the fields.")
            return;
        }

        if (passwordFieldOne.text != passwordFieldTwo.text) {

            print("Passwords do not match.")
            return;
        }

        let ent = NSEntityDescription.entity(forEntityName: "Users", in: self.context)

        let newUser = Users(entity: ent!, insertInto: self.context)

        newUser.username = nameField.text
        newUser.password = passwordFieldTwo.text

        do {
            try self.context.save()
        } catch _ {

        }
        
        userCreated = true
        
    }

    @IBAction func cancel(_ sender: UIBarButtonItem) {
        self.navigationController?.popViewController(animated: true)
        dismiss(animated: true, completion: nil)
    }
}
