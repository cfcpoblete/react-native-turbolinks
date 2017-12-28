import React, { Component } from 'react'
import { NavigatorIOS, WebView } from 'react-native'

export default class AuthenticationView extends Component {

  render() {
    return (
      <NavigatorIOS initialRoute={{component: MyScene, title: 'Sign in'}}
                    style={{flex: 1}}/>
    );
  }
}

class MyScene extends Component {

  state = { url: 'http://localhost:9292/sign-in' }

  handleNavigationStateChange = (navState) => {
    if (this.state.url != navState.url) {
      PubSub.publish('reloadEvent')
      this.props.navigator.pop()
    }
    this.setState({ url: navState.url })
  }

  render() {
    return (
      <WebView ref={(wv) => this.webview = wv }
               source={{uri: this.state.url }}
               onNavigationStateChange={this.handleNavigationStateChange}/>
    )
  }
}