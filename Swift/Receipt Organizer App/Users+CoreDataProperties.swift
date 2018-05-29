//
//  Users+CoreDataProperties.swift
//  CSE335_ClassProject
//
//  Created by student on 3/30/18.
//  Copyright © 2018 Michael Pardi. All rights reserved.
//
//

import Foundation
import CoreData


extension Users {

    @nonobjc public class func fetchRequest() -> NSFetchRequest<Users> {
        return NSFetchRequest<Users>(entityName: "Users")
    }

    @NSManaged public var username: String?
    @NSManaged public var password: String?

}
