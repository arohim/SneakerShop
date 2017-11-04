package com.agoda.sneakershop

import android.support.test.espresso.action.ViewActions.pressImeActionButton
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.agoda.sneakershop.ListScreen.Item
import com.agoda.sneakershop.screen.sneaker.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SneakerUiTest {
    @JvmField
    @Rule
    val rule = ActivityTestRule(MainActivity::class.java)

    val screen = ListScreen()
    val detailScreen = DetailScreen()

    @Test
    fun testDataLoading() {
        fun testOriginalList() {
            screen {
                recycler {
                    firstChild<Item> {
                        name { hasText(text = "Nike SF Air Force 1 Mid") }
                    }

                    lastChild<Item> {
                        name { hasText(text = "JORDAN SUPER.FLY 2017") }
                    }
                }
            }
        }

        screen {
            testOriginalList()

            searchButton { click() }

            searchEdit {
                typeText(text = "ZOOM")
                act { pressImeActionButton() }
                idle()
            }

            recycler {
                firstChild<Item> {
                    name { hasText("NIKE AIR ZOOM ELITE 9") }
                }

                lastChild<Item> {
                    name { hasText(text = "NIKE AIR ZOOM VOMEO 12") }
                    price { hasText(text = "$ 100") }
                }
            }


            searchBack {
                click()
                idle()
            }

            testOriginalList()
        }
    }

    @Test
    fun testDetailScreen() {
        screen {
            recycler {
                childAt<Item>(3) {
                    click()
                }
            }
        }

        detailScreen {
            name { hasText("NIKE AIR MAX 1 ULTRA FLYKNIT") }

            pressBack()
        }

        screen {
            recycler { isDisplayed() }
        }
    }
}