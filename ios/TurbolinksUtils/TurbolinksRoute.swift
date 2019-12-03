import Turbolinks

class TurbolinksRoute {
    var title: String?
    var subtitle: String?
    var titleImage: UIImage?
    var action: Action?
    var url: URL?
    var component: String?
    var modal: Bool = false
    var dismissable: Bool = false
    var passProps: Dictionary<AnyHashable, Any>?
    var actions: Array<Dictionary<AnyHashable, Any>>?
    var leftButtonIcon: UIImage?
    var leftButtonText: String?
    var rightButtonIcon: UIImage?
    var rightButtonText: String?
    var navBarHidden: Bool = false
    var navBarDropDown: Bool = false
    
    init(_ route: Dictionary<AnyHashable, Any>) {
        self.title = RCTConvert.nsString(route["title"])
        self.subtitle = RCTConvert.nsString(route["subtitle"])
        self.titleImage = RCTConvert.uiImage(route["titleImage"])
        self.action = Action(rawValue: RCTConvert.nsString(route["action"]) ?? "advance")
        self.url = RCTConvert.nsurl(route["url"])
        self.component = RCTConvert.nsString(route["component"])
        self.modal = RCTConvert.bool(route["modal"])
        self.dismissable = RCTConvert.bool(route["dismissable"])
        self.passProps = RCTConvert.nsDictionary(route["passProps"])
        self.actions = RCTConvert.nsDictionaryArray(route["actions"])
        self.leftButtonIcon = RCTConvert.uiImage(route["leftButtonIcon"])
        self.leftButtonText = RCTConvert.nsString(route["leftButtonText"])
        self.rightButtonIcon = RCTConvert.uiImage(route["rightButtonIcon"])
        self.rightButtonText = RCTConvert.nsString(route["rightButtonText"])
        self.navBarHidden = RCTConvert.bool(route["navBarHidden"])
        self.navBarDropDown = RCTConvert.bool(route["navBarDropDown"])
    }    
}
