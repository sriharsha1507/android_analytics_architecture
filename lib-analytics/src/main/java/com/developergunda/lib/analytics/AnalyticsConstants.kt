package com.developergunda.lib.analytics

sealed class AnalyticsConstants {
    sealed class Events {
        object Navigated {
            const val EVENT = "navigated"

            object Params {
                const val FROM = "from"
                const val TO = "to"
            }

            object NavigationSources {
                const val HOME = "home"
                const val DASHBOARD = "dashboard"
                const val NOTIFICATIONS = "notifications"
            }
        }

        object ItemClicked {
            const val EVENT = "item_selected"

            object Params {
                const val TIME_BETWEEN_CLICKS = "time_between_clicks"
                const val BUTTON_NAME = "button_name"
            }

            object ItemNames {
                const val SUBSCRIBE_BUTTON_NAME = "subscribe_button_name"
                const val BELL_ICON_FAB = "bell_icon_fab"
            }

        }

        object NotificationsChanged {
            const val EVENT = "notifications_changed"

            object Params {
                const val SETTING_STATE = "setting_state"
            }
        }

        object HomeRead {
            const val EVENT = "home_screen"

            object Params {
                const val TIME_SPENT = "time_spent"
            }
        }

        object AppUpdated {
            const val EVENT = "app_got_updated"
        }
    }
}