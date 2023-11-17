package profilerClass

import java.io.Serializable

class ProfilerList: Serializable {
    public var profilerList = mutableListOf<Profiler>()
    public var title =""
}