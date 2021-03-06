package com.rameshkp.openapi.merger.gradle.extensions

import org.gradle.api.Action
import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.Property
import javax.inject.Inject

/**
 *  An extension class for Info class
 */
open class InfoExtension @Inject constructor(objectFactory: ObjectFactory) {
    val title: Property<String> = objectFactory.property(String::class.java)
    val description: Property<String> = objectFactory.property(String::class.java)
    val termsOfService: Property<String> = objectFactory.property(String::class.java)
    val version: Property<String> = objectFactory.property(String::class.java)
    internal val contact: ContactExtension = objectFactory.newInstance(ContactExtension::class.java, objectFactory)
    internal val license: LicenseExtension = objectFactory.newInstance(LicenseExtension::class.java, objectFactory)

    /**
     *  Invoke the contact extension
     */
    fun contact(action: Action<ContactExtension>) {
        action.execute(contact)
    }

    /**
     *  Invoke the license extension
     */
    fun license(action: Action<LicenseExtension>) {
        action.execute(license)
    }
}