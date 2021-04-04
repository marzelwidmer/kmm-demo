package ch.keepcalm.kmm.shared

import co.touchlab.kermit.Logger
import co.touchlab.kermit.NSLogLogger

actual fun getLogger(): Logger = NSLogLogger()