package profiler

import java.io.Serializable

class Profiler:Serializable  {

    //This will be on the tile scene
    public var name = String()
    // Number of profiler on the select scene
    // Minimum is 1, and Maxium is 6
    public var numProf=1
    public var currentNum=0
    public var taskList = mutableListOf<ProfType>()




}