package com.feylabs.unittesting

import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

class MainViewModelTest : TestCase() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var cuboidModel: CuboidModel


    private val dummyLength = 12.0
    private val dummyWidth = 7.0
    private val dummyHeight = 6.0

    private val dummyVolume = 504.0
    private val dummyCircumference = 100.0
    private val dummySurfaceArea = 396.0


    @Before
    fun before() {
        cuboidModel = mock(cuboidModel::class.java)
        mainViewModel = MainViewModel(cuboidModel)
    }

    @Test
    fun testVolume() {
        cuboidModel = CuboidModel()
        mainViewModel = MainViewModel(cuboidModel)
        mainViewModel.save(dummyLength, dummyWidth, dummyHeight)
        val volume = mainViewModel.getVolume()
        assertEquals(dummyVolume, volume, 0.001)
    }

    @Test
    fun testCircumference() {
        cuboidModel = CuboidModel()
        mainViewModel = MainViewModel(cuboidModel)
        mainViewModel.save(dummyLength, dummyWidth, dummyHeight)
        val circumference = mainViewModel.getCircumference()
        assertEquals(dummyCircumference, circumference)
    }

    @Test
    fun testSurfaceArea() {
        cuboidModel = CuboidModel()
        mainViewModel = MainViewModel(cuboidModel)
        mainViewModel.save(dummyLength, dummyWidth, dummyHeight)
        val surfaceArea = mainViewModel.getSurfaceArea()
        assertEquals(dummySurfaceArea, surfaceArea)
    }



}